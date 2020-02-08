//ExampleSingle.java
/**
 * 单例设计模式之饿汉式
 * @data:2020年2月4日
 */
class Single {
    private Single (){}
    private static Single single  = new Single();
    private int num = 0;
    public static Single getInstance(){
        return single;
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return this.num;
    }
}

public class ExampleSingle{

    public static void main(String[] args)
    {
        Single single = Single.getInstance();
        System.out.println(single.getNum()); // 0
        single.setNum(10);
        System.out.println(single.getNum()); //10

        Single single1 = Single.getInstance();
        System.out.println(single1.getNum()); //10
    }
}