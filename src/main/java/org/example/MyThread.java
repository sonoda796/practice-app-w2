package org.example;

public class MyThread extends Thread {
    @Override
    public void run() {
        // スレッドで実行する処理
        for (int i = 0; i < 5; i++) {
            System.out.println("スレッド実行中: " + i);
            try {
                Thread.sleep(1000); // 1秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
