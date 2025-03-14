package practice.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {
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
