package Task8.Visitor;

public class Client {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        Element elementA = new ConcreteElementA();
        Element elementB = new ConcreteElementB();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
