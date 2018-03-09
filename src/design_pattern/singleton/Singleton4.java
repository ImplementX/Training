package design_pattern.singleton;

//双重锁模式
public class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {
        System.out.println("Singleton has loaded");
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
