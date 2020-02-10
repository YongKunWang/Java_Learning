public class ManagerTest{
    public static void main(String[] args)
    {
        Manager manager = new Manager("Bob", 5000.0, 1000.0);
        System.out.println(manager.getName());
        System.out.println(manager.getSalary());
        System.out.println(manager.getBonus());
    }
}