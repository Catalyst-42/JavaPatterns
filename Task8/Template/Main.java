package Task8.Template;

public class Main {
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();

        class1.templateMethod();
        class2.templateMethod();
    }
}
