import java.util.ArrayList;

public class ExArrayList{

    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(5);
        arrayList1.size();
        /**
         * 下标从0开始
         */
        arrayList1.add(0,1);

        for (int num : arrayList1) {
            System.out.println(num);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('H');
        stringBuffer.append('e');
        stringBuffer.append('l');
        stringBuffer.append('l');
        stringBuffer.append('o');
        stringBuffer.append('!');
        String str = stringBuffer.toString();
        System.out.println(str);
    }
}