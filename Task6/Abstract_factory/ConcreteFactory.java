package Task6.Abstract_factory;

public class ConcreteFactory implements AbstractFactory {
    @Override
    public AbstractProduct createProductA() {
        return new ConcreteProduct();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ConcreteProduct();
    }
}
