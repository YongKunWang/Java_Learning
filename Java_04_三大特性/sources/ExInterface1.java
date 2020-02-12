import java.util.*;
abstract class Person {
    String name;
    int age;
    public abstract void show();
}

class Student extends Person implements Comparable<Student>{
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println("studnet: " + name + "age: " + age);
    }
    /**
     * 排序一定要实现Comparable接口中的compareTo方法
     * 
     */
    @Override
    public int compareTo(Student s){
        return Integer.compare(age, s.age);
    }
}

public class ExInterface1{

    public static void main(String[] args)
    {
        Student s1 = new Student("Bob",20);
        Student s2 = new Student("Alice",21);
        Student[] s3 = new Student[2];
        s3[0] = s1;
        s3[1] = s2;
        Arrays.sort(s3);
        for (Student student : s3) {
            student.show();
        }
    }
}