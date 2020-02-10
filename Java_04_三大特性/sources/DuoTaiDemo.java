abstract class Animal {
    abstract void eat();
}
class Cat extends Animal {
    public void eat(){
        System.out.println("eat fish ...");
    }
    public void catchMouse(){
        System.out.println("catch Mouse...");
    }
}
class Dog extends Animal {
    public void eat(){
        System.out.println("eat bones...");
    }
    public void kanJia(){
        System.out.println("Kan jia ...");
    }
}


public class DuoTaiDemo{

    public static void main(String[] args)
    {
        Cat cat = new Cat();
        function(cat);
        Dog dog = new Dog();
        function(dog);

        Animal cat1 = new Cat();
        //虽然父类是抽象类，但是自动调用子类的方法
        //提高了代码额拓展性
        function(cat1);
        Animal dog1 = new Dog();
        function(dog1);


    }

    public static void function(Cat c){
        c.eat();
        c.catchMouse();
    }
    public static void function(Dog d){
        d.eat();
        d.kanJia();
    }
    public static void function(Animal a){
        a.eat();

        if (a instanceof Cat){
            //向下转型
            Cat cat = (Cat)a;
            cat.catchMouse();
        }
        else if(a instanceof Dog){
            //向下转型
            Dog dog = (Dog)a;
            dog.kanJia();
        }
    }
}

