package Task6.Prototype;

public class ConcretePrototype2 implements Prototype {
    private int id;

    public ConcretePrototype2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Prototype clone() {
        return this;
    }
}
