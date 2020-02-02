public class ExampleBit{

    public static void main(String[] args)
    {
        System.out.println(2 << 3);
        /* 
            0000 0010 2
            0000 0100 4
            0000 1000 8
            0001 0000 16
        */

        int a = 2;  // 0000 0010
        int b = 4;  // 0000 0100

        a ^= b;     // 0000 0110
        b ^= a;     // 0000 0010
        a ^= b;     // 0000 0100
        /* 原理：
                异或：相同为0，不同为1
                其中一个数与另一个给定值异或两次值不变
                a = a^b^a
        */
        System.out.println(a+ "," + b);
    }
}