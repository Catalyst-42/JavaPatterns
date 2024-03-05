package Task8.Visitor;

public class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ConcreteElementA a) {
        System.err.println("visit a");
    }
    
    @Override
    public void visitElementB(ConcreteElementB b) {
        System.err.println("visit b");
    }
}
