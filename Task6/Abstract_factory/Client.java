package Task6.Abstract_factory;

public class Client {
    private AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public void doSomething() {
        AbstractProduct productA = factory.createProductA();
        AbstractProduct productB = factory.createProductB();

        productA.doSomething();
        productB.doSomething();
    }
}