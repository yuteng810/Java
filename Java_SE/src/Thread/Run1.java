package Thread;

public class Run1 {
    public static void main(String[] args) {
        MyRun my = new MyRun();
        Thread t1 = new Thread(my);
        t1.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyRun implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("MyRun:" + i);
        }
    }
}
