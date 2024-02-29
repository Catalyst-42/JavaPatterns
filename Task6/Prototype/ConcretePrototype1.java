package Task6.Prototype;

public class ConcretePrototype1 implements Prototype {
    private String name;

    public ConcretePrototype1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return this;
    }
}
