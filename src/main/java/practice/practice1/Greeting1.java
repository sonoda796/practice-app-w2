package practice.practice1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Greeting1 {

    public PrintGreet1 setPrintGreet(String msg) {
        return new PrintGreet1(msg);
    }

    public static void main(String[] args) {

        ExecutorService firstExecutor = Executors.newSingleThreadExecutor();
        ExecutorService secondExecutor = Executors.newSingleThreadExecutor();
        ExecutorService thirdExecutor = Executors.newSingleThreadExecutor();

        PrintGreet1 printGreet1 = new PrintGreet1("おはよう");
        PrintGreet1 printGreet2 = new PrintGreet1("おやすみ");
        PrintGreet1 printGreet3 = new PrintGreet1("ありがとう");

        firstExecutor.submit(printGreet1::run);
        secondExecutor.submit(printGreet2::run);
        thirdExecutor.submit(printGreet3::run);
    }
}
