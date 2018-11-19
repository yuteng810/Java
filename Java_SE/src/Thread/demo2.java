package Thread;

public class demo2 {

    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {

        if (num<0){
            num=0;
        }
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
