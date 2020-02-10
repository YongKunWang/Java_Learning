public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus){
        super(name,salary);
        this.bonus = bonus;
    }
    public String getName(){
        //只能使用这种方式，因为为私有变量
        //只能通过super关键字来调用
        //子类无法直接访问
        return super.getName();
    }
    public double getSalary() {
        return super.getSalary();
    }
    public double getBonus() {
        return bonus;
    }
}