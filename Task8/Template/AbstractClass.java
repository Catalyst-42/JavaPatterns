package Task8.Template;

public abstract class AbstractClass {

    // The template method
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // Abstract methods that will be implemented by subclasses
    protected abstract void step1();

    protected abstract void step3();

    // Concrete method
    private void step2() {
        System.out.println("Executing step 2...");
    }
}