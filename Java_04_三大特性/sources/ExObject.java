class Demo {
    private int num;
    Demo(int num){
        this.num = num;
    }
    @Override 
    public boolean equals(Object obj){
        /**
         * 确保相比较的是同一个类生成的对象
         */
        if(!(obj instanceof Demo))
            /**
             * 直接返回
             * 或者抛出异常信息
             */
            return false;
        /**
         * 显式声明为Object，此为向上转型
         * 当在函数中需要使用子类的特有数据是，需要向下转型！
         */
        Demo demo = (Demo)obj;
        return this.num == demo.num;
    }
}
class Person {

}

public class ExObject{

    public static void main(String[] args)
    {
        Demo demo1 = new Demo(1);
        Demo demo2 = new Demo(2);
        Demo demo3 = demo1;
        Person person = new Person();
        System.out.println(demo1.equals(demo2));
        System.out.println(demo1.equals(demo3));
        System.out.println(demo1.equals(person));

        System.out.println(demo1.toString());
        System.out.println(demo1.getClass().getName()+"@"+Integer.toHexString(demo1.hashCode()));
    }
}