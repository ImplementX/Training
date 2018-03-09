package design_pattern.singleton;

//枚举模式
//自由序列化
//保证只有一个实例
//线程安全
public enum Singleton5 {
    INSTANCE;

    public void otherMethods() {
        System.out.println("Something");
    }

}

//调用方式
class Hello {
    public static void main(String[] args) {
        Singleton5.INSTANCE.otherMethods();
    }
}
