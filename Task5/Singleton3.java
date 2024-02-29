package Task5;

public class Singleton3 {
    private static final Singleton3 instance;
    private double some = 0;
    
    // static init block
    static {
        instance = new Singleton3();
    }
    
    private Singleton3() {}
    
    public static Singleton3 getInstance() {
        return instance;
    }

    public double getSome() {
        return some;
    }

    public void setSome(double some) {
        this.some = some;
    }
}