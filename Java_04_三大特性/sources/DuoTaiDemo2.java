class Fu {
    void m1(){
        System.out.println("fu m1");
    }
    void m2(){
        System.out.println("fu m2");
    }
    
}
class Zi extends Fu{
    void m1(){
        System.out.println("zi m1");
    }
    void m3(){
        System.out.println("zi m3");
    }
    
}
public class DuoTaiDemo2{

    public static void main(String[] args)
    {
        Fu f = new Fu();
        f.m1();
        f.m2();

        //向上转型
        Fu fz = new Zi();
        fz.m1();
        fz.m2();
        //编译期间看左边
        //fz.m3();

        Zi zf = (Zi)f;
        zf.m1();
        zf.m2();
        zf.m3();
    }
}