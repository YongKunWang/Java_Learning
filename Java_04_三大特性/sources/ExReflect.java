class Personn {
    private String name;
    private int age;

    public Personn(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("Nmae: " + name + "age: " + age +  "eat...");
    }

}

public class ExReflect{

    public static void main(String[] args)
    {
        Personn p = new Personn("Bob", 20);
        p.eat();
    }
}