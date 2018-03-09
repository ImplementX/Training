package design_pattern.singleton;

//静态内部类
//静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载
//达到了类似懒汉模式的效果
//线程安全。

public class Singleton3 {
    private static class SingletonHolder{
        private static Singleton3 instance=new Singleton3();
    }
    private Singleton3(){
        System.out.println("Singleton2 has loaded");
    }
    public static Singleton3 getInstance(){
        return SingletonHolder.instance;
    }
}
