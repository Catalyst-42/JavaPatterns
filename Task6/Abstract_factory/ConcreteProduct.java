package Task6.Abstract_factory;

public class ConcreteProduct implements AbstractProduct {
    @Override
    public void doSomething() {
        System.out.println(this.getClass());
    }
}
