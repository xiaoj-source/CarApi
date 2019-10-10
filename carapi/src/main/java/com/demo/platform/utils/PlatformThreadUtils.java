package com.demo.platform.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 异步处理工具类，主线程或者其他线程执行。
 * Since 1.0.0
 */

public class PlatformThreadUtils {

    private final static int THREAD_POOL_SIZE = 4;
    private final static ExecutorService sThreadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE, new ThreadFactoryBuilder().setNameFormat("order-%d").setDaemon(false).build());
    // 线程分类，运行优先级UI > NORMAL > BACKGROUND,默认是UI
    public static final int THREAD_BACKGROUND = 0;
    public static final int THREAD_UI = 1;
    public static final int THREAD_NORMAL = 2;

    private static ConcurrentHashMap<Object, RunnableMap> sRunnableCache = new ConcurrentHashMap<Object, RunnableMap>();

    private static Handler sMainThreadHandler;
    private static volatile HandlerThread sBackgroundThread;
    private static Handler sBackgroundHandler;
    private static volatile HandlerThread sNormalThread;
    private static Handler sNormalHandler;

    private PlatformThreadUtils() {

    }

    /**
     * 获取指定threadType的looper
     *
     * @param threadType
     * @return
     */
    public static Looper getLooper(int threadType) {
        switch (threadType) {
            case THREAD_BACKGROUND:
                createBackgroundThread();
                return sBackgroundThread.getLooper();
            case THREAD_UI:
                createMainThread();
                return sMainThreadHandler.getLooper();
            case THREAD_NORMAL:
                createNormalThread();
                return sNormalHandler.getLooper();
            default:
                throw new IllegalArgumentException("invalid threadType:" + threadType);
        }
    }

    /**
     * 在主线程执行
     *
     * @param runner 目标Runnable
     */
    public static void runOnMainThread(Runnable runner) {
        post(THREAD_UI, runner);
    }

    /**
     * 在主线程延时执行
     *
     * @param runner  目标Runnable
     * @param delayMs 延时毫秒数
     */
    public static void runOnMainThreadDelay(Runnable runner, long delayMs) {
        postDelayed(THREAD_UI, runner, delayMs);
    }

    /**
     * 最基础的多线程执行
     *
     * @param runnable 目标Runnable
     */
    public static void execute(final Runnable runnable) {
        execute(runnable, null, android.os.Process.THREAD_PRIORITY_BACKGROUND);
    }

    /**
     * 带回调的多线程
     *
     * @param runnable 目标Runnable
     * @param callback 回调
     */
    public static void execute(final Runnable runnable, final Runnable callback) {
        execute(runnable, callback, android.os.Process.THREAD_PRIORITY_BACKGROUND);
    }

    /**
     * 带回调，可以设置优先级的多线程
     *
     * @param runnable 目标Runnable
     * @param callback 回调
     * @param priority 优先级，默认 android.os.Process.THREAD_PRIORITY_BACKGROUND
     */
    public static void execute(final Runnable runnable, final Runnable callback, final int priority) {
        try {
            if (!sThreadPool.isShutdown()) {
                Handler handler = null;
                if (callback != null) {
                    handler = new Handler(Looper.myLooper());
                }
                final Handler finalHandler = handler;
                sThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        android.os.Process.setThreadPriority(priority);
                        runnable.run();
                        if (finalHandler != null && callback != null) {
                            finalHandler.post(callback);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将Runnable添加到消息队列中执行，执行顺序：前置callback->task->后置callback
     *
     * @param threadType           类型
     * @param preCallback          先执行的任务
     * @param task                 目标Runnable
     * @param postCallback         后执行的任务
     * @param callbackToMainThread callback是否主线程执行
     */
    public static void post(int threadType, final Runnable preCallback, final Runnable task, final Runnable postCallback, boolean callbackToMainThread) {
        doPost(threadType, preCallback, task, postCallback, callbackToMainThread, 0);
    }

    /**
     * 将Runnable添加到消息队列中执行，执行顺序：task->后置callback
     *
     * @param threadType           类型
     * @param task                 目标Runnable
     * @param postCallback         后执行的任务
     * @param callbackToMainThread callback是否主线程执行
     */
    public static void post(int threadType, final Runnable task, final Runnable postCallback, boolean callbackToMainThread) {
        doPost(threadType, null, task, postCallback, callbackToMainThread, 0);
    }

    /**
     * 将Runnable添加到消息队列中执行
     *
     * @param threadType 类型
     * @param task       目标Runnable
     */
    public static void post(int threadType, Runnable task) {
        doPost(threadType, null, task, null, false, 0);
    }

    /**
     * 将Runnable添加到消息队列中执行
     *
     * @param threadType  类型
     * @param task        目标Runnable
     * @param delayMillis 延时毫秒数
     */
    public static void postDelayed(int threadType, Runnable task, long delayMillis) {
        doPost(threadType, null, task, null, false, delayMillis);
    }


    /**
     * 将Runnable添加post到UI线程执行
     *
     * @param task
     */
    public static void postMainThread(Runnable task) {
        doPost(THREAD_UI, null, task, null, false, 0);
    }

    /**
     * 将Runnable添加post到ui线程执行
     *
     * @param task
     * @param delayMillis
     */
    public static void postMainThread(Runnable task, long delayMillis) {
        doPost(THREAD_UI, null, task, null, false, delayMillis);
    }

    /**
     * 将Runnable添加post到normal线程执行
     *
     * @param task
     */
    public static void postNormal(Runnable task) {
        doPost(THREAD_NORMAL, null, task, null, false, 0);
    }

    /**
     * 将Runnable添加post到normal线程执行
     *
     * @param task
     * @param delayMillis
     */
    public static void postNormal(Runnable task, long delayMillis) {
        doPost(THREAD_NORMAL, null, task, null, false, delayMillis);
    }

    /**
     * 将Runnable添加post到后台线程执行
     *
     * @param task
     */
    public static void postBackground(Runnable task) {
        doPost(THREAD_BACKGROUND, null, task, null, false, 0);
    }

    /**
     * 将Runnable添加post到后台线程执行
     *
     * @param task
     * @param delayMillis
     */
    public static void postBackground(Runnable task, long delayMillis) {
        doPost(THREAD_BACKGROUND, null, task, null, false, delayMillis);
    }


    /**
     * 将Runnable添加到消息队列中执行
     *
     * @param threadType           类型
     * @param preCallback          先执行的任务
     * @param task                 目标Runnable
     * @param postCallback         后执行的任务
     * @param callbackToMainThread callback是否在主线程回调
     * @param delayMillis          延时毫秒数
     */
    private static void doPost(final int threadType, final Runnable preCallback, final Runnable task, final Runnable postCallback, final boolean callbackToMainThread, long delayMillis) {
        if (task == null) {
            return;
        }
        if (sMainThreadHandler == null) {
            createMainThread();
        }
        Handler handler = null;
        switch (threadType) {
            case THREAD_BACKGROUND:
                if (sBackgroundThread == null) {
                    createBackgroundThread();
                }
                handler = sBackgroundHandler;
                break;
            case THREAD_NORMAL:
                if (sNormalThread == null) {
                    createNormalThread();
                }
                handler = sNormalHandler;
                break;
            case THREAD_UI:
                handler = sMainThreadHandler;
                break;
            default:
                handler = sMainThreadHandler;
                break;
        }

        //增加判空处理，改为强制在主线程执行
        if (handler == null) {
            handler = sMainThreadHandler;
        }
        final Handler finalHandler = handler;

        Looper myLooper = null;
        if (callbackToMainThread == false) {
            myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = sMainThreadHandler.getLooper();
            }
        }
        final Looper looper = myLooper;
        final Runnable postRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                if (postCallback != null) {
                    if (callbackToMainThread || (looper == sMainThreadHandler.getLooper())) {
                        sMainThreadHandler.post(postCallback);
                    } else {
                        new Handler(looper).post(postCallback);
                    }
                }

                sRunnableCache.remove(task);
            }
        };

        Runnable realRunnable = new Runnable() {
            @Override
            public void run() {
                if (preCallback != null) {
                    if (callbackToMainThread || (looper == sMainThreadHandler.getLooper())) {
                        sMainThreadHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                preCallback.run();
                                finalHandler.post(postRunnable);
                            }
                        });
                    } else {
                        new Handler(looper).post(new Runnable() {
                            @Override
                            public void run() {
                                preCallback.run();
                                finalHandler.post(postRunnable);
                            }
                        });
                    }
                } else {
                    postRunnable.run();
                }
            }
        };

        finalHandler.postDelayed(realRunnable, delayMillis);

        if (preCallback == null) {
            sRunnableCache.put(task, new RunnableMap(realRunnable, threadType));
        } else {
            sRunnableCache.put(task, new RunnableMap(postRunnable, threadType));
        }
    }

    /**
     * 清除消息队列中对应的Runnable
     *
     * @param task 目标task
     */
    public static void removeRunnable(final Runnable task) {
        if (task == null) {
            return;
        }

        RunnableMap map = sRunnableCache.remove(task);
        if (map == null) {
            return;
        }

        Runnable realRunnable = map.getRunnable();
        if (realRunnable != null) {
            switch (map.getType()) {
                case THREAD_BACKGROUND:
                    if (sBackgroundHandler != null) {
                        sBackgroundHandler.removeCallbacks(realRunnable);
                    }
                    break;
                case THREAD_UI:
                    if (sMainThreadHandler != null) {
                        sMainThreadHandler.removeCallbacks(realRunnable);
                    }
                    break;
                case THREAD_NORMAL:
                    if (sNormalHandler != null) {
                        sNormalHandler.removeCallbacks(realRunnable);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static class RunnableMap {
        private Runnable mRunnable;
        private Integer mType;

        public RunnableMap(Runnable runnable, Integer type) {
            mRunnable = runnable;
            mType = type;
        }

        public Runnable getRunnable() {
            return mRunnable;
        }

        public int getType() {
            return mType;
        }
    }

    private static synchronized void createMainThread() {
        if (sMainThreadHandler == null) {
            sMainThreadHandler = new Handler(Looper.getMainLooper());
        }
    }

    private static synchronized void createBackgroundThread() {
        if (sBackgroundThread == null) {
            sBackgroundThread = new HandlerThread("BackgroundHandler", android.os.Process.THREAD_PRIORITY_BACKGROUND);
            sBackgroundThread.start();
            sBackgroundHandler = new Handler(sBackgroundThread.getLooper());
        }
    }

    private static synchronized void createNormalThread() {
        if (sNormalThread == null) {
            sNormalThread = new HandlerThread("NormalHandler", android.os.Process.THREAD_PRIORITY_DEFAULT);
            sNormalThread.start();
            sNormalHandler = new Handler(sNormalThread.getLooper());
        }
    }

    /**
     * 销毁HandlerThread
     */
    public static synchronized void destroy() {
        if (sBackgroundThread != null) {
            sBackgroundThread.quit();
            try {
                sBackgroundThread.interrupt();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            sBackgroundThread = null;
        }

        if (sNormalThread != null) {
            sNormalThread.quit();
            try {
                sNormalThread.interrupt();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            sNormalThread = null;
        }

    }


    /**
     * BackgroundHandler上判断是否有runnable或message-----begin
     */
    public static boolean hasCallbacksOnBackground(Runnable runnable) {
        return sBackgroundHandler != null && sBackgroundHandler.hasCallbacks(runnable);

    }

    public static boolean hasMessagesOnBackground(int what, Object object) {
        return sBackgroundHandler != null && sBackgroundHandler.hasMessages(what, object);
    }

    public static boolean hasMessagesOnBackground(int what) {
        return sBackgroundHandler != null && sBackgroundHandler.hasMessages(what);
    }

    /**
     *
     * BackgroundHandler上判断是否有runnable或message-----end
     */


    /**
     * MainHandler上判断是否有runnable或message-----begin
     */
    public static boolean hasCallbacksOnMain(Runnable runnable) {
        return sMainThreadHandler != null && sMainThreadHandler.hasCallbacks(runnable);
    }

    public static boolean hasMessagesOnMain(int what, Object object) {
        return sMainThreadHandler != null && sMainThreadHandler.hasMessages(what, object);
    }

    public static boolean hasMessagesOnMain(int what) {
        return sMainThreadHandler != null && sMainThreadHandler.hasMessages(what);
    }

    /**
     *
     * MianHandler上判断是否有runnable或message-----end
     */


    /**
     * NormalHandler上判断是否有runnable或message-----begin
     */
    public static boolean hasCallbacksOnNormal(Runnable runnable) {
        return sNormalHandler != null && sNormalHandler.hasCallbacks(runnable);
    }

    public static boolean hasMessagesOnNormal(int what, Object object) {
        return sNormalHandler != null && sNormalHandler.hasMessages(what, object);
    }

    public static boolean hasMessagesOnNormal(int what) {
        return sNormalHandler != null && sNormalHandler.hasMessages(what);
    }

    /**
     *
     * NormalHandler上判断是否有runnable或message-----end
     */


    /**
     * ThreadFactoryBuilder構建ThreadFactory
     */
    private static class ThreadFactoryBuilder {
        private static final String NAME = "newFixedThreadPool";
        private static final boolean DAEMON_VALUE = false;
        private String mName = NAME;
        private boolean mDaemon = DAEMON_VALUE;
        private ThreadFactory mThreadFactory;
        private String mNameFormat;

        public ThreadFactory getThreadFactory() {
            return mThreadFactory;
        }

        public ThreadFactoryBuilder setThreadFactory(ThreadFactory mThreadFactory) {
            this.mThreadFactory = mThreadFactory;
            return this;
        }

        public String getNameFormat() {
            return mNameFormat;
        }

        ThreadFactoryBuilder setNameFormat(String mNameFormat) {
            this.mNameFormat = mNameFormat;
            return this;
        }

        public String getName() {
            return mName;
        }


        public boolean ismDaemon() {
            return mDaemon;
        }

        ThreadFactoryBuilder setDaemon(boolean mDaemon) {
            this.mDaemon = mDaemon;
            return this;
        }

        ThreadFactory build() {

            return new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    ThreadFactory threadFactory = mThreadFactory != null ? mThreadFactory : Executors.defaultThreadFactory();
                    Thread thread = threadFactory.newThread(r);
                    AtomicLong count = (mNameFormat != null) ? new AtomicLong(0) : null;
                    if (mNameFormat != null) {
                        thread.setName(String.format(Locale.ROOT, mNameFormat, count.getAndIncrement()));
                    }
                    thread.setDaemon(mDaemon);
                    return thread;
                }
            };
        }
    }

}
