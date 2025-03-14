package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadSample {

//    public static void main(String[] args) {
//        // 固定数のスレッドプールを作成
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//
//        try {
//            // タスクの実行
//            Future<?> future1 = executor.submit(() -> {
//                System.out.println("タスク1実行中...");
//                return "タスク1完了";
//            });
//
//            Future<?> future2 = executor.submit(() -> {
//                System.out.println("タスク2実行中...");
//                return "タスク2完了";
//            });
//
//            // 結果の取得
//            System.out.println(future1.get());
//            System.out.println(future2.get());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // ExecutorServiceのシャットダウン
//            executor.shutdown();
//        }
//    }

//    // 必要に応じてスレッドを増減
//    // newCachedThreadPoolメソッド
//    public static void main(String[] args) throws InterruptedException {
//        //タスクを持つ新しいスレッドを作成
//        ExecutorService exec = Executors.newCachedThreadPool();
//
//        try {
//            Runnable test = () -> {
//                System.out.println(Thread.currentThread().getId());
//            };
//            //タスクを与えて、実行する
//            for (int i = 0; i < 3; i++) {
//                exec.submit(test);
//            }
//
//            //65秒間mainメソッドを停止
//            Thread.sleep(1 * 65000);
//            System.out.println("------65秒後-------");
//            System.out.println(Thread.currentThread().getId());
//
//            //タスクを与えて、実行する
//            for (int i = 0; i < 5; i++) {
//                exec.submit(test);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // ExecutorServiceのシャットダウン
//            exec.shutdown();
//        }
//    }

    // 時間のかかる処理を待たずに処理を進める
    public static void main(String[] args) throws InterruptedException {
        // 固定数のスレッドプールを作成
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println(Thread.currentThread().getId());

        try {
            // タスクの実行
            executor.submit(() -> {
                System.out.println("タスク1実行中...");

                try {

                    System.out.println(Thread.currentThread().getId());

                    //10秒間mainメソッドを停止
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                }
                System.out.println("------10秒後-------");
                System.out.println("タスク1完了...");

            });
            executor.submit(() -> {
                System.out.println("タスク2完了");
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ExecutorServiceのシャットダウン
            executor.shutdown();
        }
    }
}