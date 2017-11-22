package defy.com.mvp.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by chenglei on 2017/11/3.
 */

public class AppExecutor {

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private static AppExecutor instance;

    public AppExecutor() {
        diskIO = Executors.newSingleThreadExecutor();
        networkIO = Executors.newFixedThreadPool(3);
        mainThread = new MainThreadExecutor();
    }

    public static AppExecutor getInstance() {
        if (instance == null)
            instance = new AppExecutor();
        return instance;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
