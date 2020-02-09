/**
 * 区分equals和 == 的区别
 * 
 */
public class Example1{

    public static void main(String[] args)
    {
        String str1 = "Hello World!!";
        String str2 = "Hello World!!";
        System.out.println(str1.equals(str2));
        String str3 = str1;
        System.out.println(str3 == str1);
    }
}