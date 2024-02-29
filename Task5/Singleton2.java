package Task5;

public enum Singleton2 {
    // enum
    INSTANCE;
    private double some = 0;
    
    public Singleton2 getInstance() {
        return INSTANCE;
    }

    public double getSome() {
        return some;
    }

    public void setSome(double some) {
        this.some = some;
    }
}