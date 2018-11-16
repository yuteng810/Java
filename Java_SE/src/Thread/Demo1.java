package Thread;

public class Demo1 extends Thread {

    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        Print();
    }

    public void Print() {
        for (int i = 0; i < 10; i++) {
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("张三");
        Demo1 demo2 = new Demo1("李四");
        demo1.start();
        demo2.start();
    }


}
