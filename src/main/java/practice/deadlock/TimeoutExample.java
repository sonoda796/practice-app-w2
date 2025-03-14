package practice.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeoutExample {

    public static void main(String[] args) {
        ExecutorService cachedExecutor  = Executors.newCachedThreadPool();

        TimeoutExample timeoutExample = new TimeoutExample();

        cachedExecutor.submit(() -> {
            System.out.println("実行スレッド：" + Thread.currentThread().getId());
            timeoutExample.processWithTimeout(900);
        });

        cachedExecutor.submit(() -> {
            System.out.println("実行スレッド：" + Thread.currentThread().getId());
            timeoutExample.processWithTimeout(900);
        });
    }

    private final Lock lock = new ReentrantLock();

    public void processWithTimeout(int exeTime) {
        try {
            // タイムアウト付きでロック取得を試みる
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    // 処理
                    Thread.sleep(exeTime);
                    System.out.println("実行スレッド：" + Thread.currentThread().getId() + "の処理が完了しました");
                } finally {
                    lock.unlock();
                }
            } else {
                // タイムアウト時の処理
                System.out.println("ロック取得がタイムアウトしました");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
