package Task5;

public class Main {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton2 s2 = Singleton2.INSTANCE;
        Singleton3 s3 = Singleton3.getInstance();
        
        
        System.out.println(s1.getSome());
        System.out.println(s2.getSome());
        System.out.println(s3.getSome());
        
        s1.setSome(32);
        s2.setSome(32);
        s3.setSome(32);

        Singleton1 ss1 = Singleton1.getInstance();
        Singleton2 ss2 = Singleton2.INSTANCE;
        Singleton3 ss3 = Singleton3.getInstance();

        System.out.println(ss1.getSome());
        System.out.println(ss2.getSome());
        System.out.println(ss3.getSome());
    }
}
