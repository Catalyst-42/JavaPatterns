package Task8.Visitor;

public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementB(this);
    }
}
