package practice.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceManager {
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        ExecutorService firstExecutor = Executors.newSingleThreadExecutor();
        ExecutorService secondExecutor = Executors.newSingleThreadExecutor();

        ResourceManager resourceManager = new ResourceManager();

        for(int i = 0; i < 10; i++) {

            firstExecutor.submit(() -> {
                resourceManager.process1();
            });
            secondExecutor.submit(() -> {
                resourceManager.process2();
            });

            detectDeadlock();
        }
    }

    public void process1() {
        // 常に同じ順序でロックを取得
        synchronized (LOCK_1) {
            System.out.println("process1_lock1取得");
            synchronized (LOCK_2) {
                // 処理
                System.out.println("process1_lock2取得");
            }
        }
    }

    public void process2() {
        // 常に同じ順序でロックを取得
        synchronized (LOCK_2) {
            System.out.println("process2_lock1取得");
            synchronized (LOCK_1) {
                // 処理
                System.out.println("process2_lock2取得");
            }
        }
    }

    public static void detectDeadlock() {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadBean.findDeadlockedThreads();

        if (threadIds != null) {
            ThreadInfo[] threadInfos = threadBean.getThreadInfo(threadIds);
            System.out.println("デッドロックを検出:");
            for (ThreadInfo info : threadInfos) {
                System.out.println(info.getThreadName() + " - " +
                        info.getLockName() + " 待ち");
            }
        }
    }
}
