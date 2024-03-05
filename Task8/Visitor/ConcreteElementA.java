package Task8.Visitor;

public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementA(this);
    }
}
