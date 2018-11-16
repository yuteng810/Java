package Thread;

public class SaleTickets extends Thread {

    static int tickets = 10000;

    public SaleTickets(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println("卖到了第：" + tickets + "张" + "\t线程：" + getName());
            tickets--;
        }
    }

}

class Demo2 {


    public static void main(String[] args) {
        SaleTickets s1 = new SaleTickets("1");
        SaleTickets s2 = new SaleTickets("2");
        SaleTickets s3 = new SaleTickets("3");
        SaleTickets s4 = new SaleTickets("4");
        SaleTickets s5 = new SaleTickets("5");
        SaleTickets s6 = new SaleTickets("6");
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();


    }
}
