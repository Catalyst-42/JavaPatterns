package Task6.Prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype1 = new ConcretePrototype1("Prototype1");
        Prototype prototype2 = new ConcretePrototype2(1);

        Prototype clonedPrototype1 = prototype1.clone();
        Prototype clonedPrototype2 = prototype2.clone();

        System.out.println("P1: " + prototype1.getClass().getSimpleName());
        System.out.println("P1 clone: " + clonedPrototype1.getClass().getSimpleName());

        System.out.println("P2: " + prototype2.getClass().getSimpleName());
        System.out.println("P2 clone: " + clonedPrototype2.getClass().getSimpleName());
    }
}
