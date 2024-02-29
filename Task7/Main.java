package Task7;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Composite composite = new Composite();

        facade.addComponent(composite);
        facade.addComponent(leaf1);
        facade.addComponent(leaf2);
        facade.performOperation();
    }
}
