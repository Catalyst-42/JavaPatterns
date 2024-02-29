package Task6.Builder;

public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildPart() {
        // Build...
    }

    @Override
    public Product getResult() {
        return this.product;
    }
}