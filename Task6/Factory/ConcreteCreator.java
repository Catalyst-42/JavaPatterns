package Task6.Factory;

public class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }

    @Override
    public void anOperation() {
        return;
    }
}

