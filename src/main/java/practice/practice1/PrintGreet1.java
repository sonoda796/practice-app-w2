package practice.practice1;

public class PrintGreet1 {

    private String msg;

    public PrintGreet1(String inputMsg){
       this.msg = inputMsg;
    }

    public void run() {

        int i = 0;

        while (i < 3){
            try{
                i += 1;
                System.out.println(msg);
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
