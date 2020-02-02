public class DataTypeConversion{
    public static void main(String[] args){
        byte a = 3;
        short b = 3;
        char c = 3;
        //自动类型转换
        int d = a;
        int e = b;
        int f = c;
        //强制类型转换
        byte h = 4;
        //错误: 不兼容的类型: 从int转换到byte可能会有损失 
        //h = h + 4;
        /*
            h + 4 的类型为int
            将int类型的变量赋值给byte类型，会造成精度损失的现象，
            这在Java中是不允许的，由JVM抛出错误
        */
        h = (byte)(h + 4);
        System.out.println("h = " + h);
        byte b1 = 3;
        byte b2 = 4;
        byte b3 ;
        // error
        //b3 = b1 + b2;
        b3 = 3 + 4;
        /*
         3,4都是常量，具有常量类型优化机制，可以直接识别为byte
         两个常量相加，先计算常量数值，然后判断是否满足类型范围
         */
        //error
        //b3 = 124 + 10;
        System.out.println("b3 = " + b3);
        System.out.println('a');
        System.out.println('a' + 1);
    }
}