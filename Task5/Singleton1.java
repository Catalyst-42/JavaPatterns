package Task5;

public class Singleton1 {
    private static Singleton1 instance;
    private double some = 0;
    
    // lazy init getInstance
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }

        return instance;
    }

    public double getSome() {
        return some;
    }

    public void setSome(double some) {
        this.some = some;
    }
}
