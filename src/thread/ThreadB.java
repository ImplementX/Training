package thread;

public class ThreadB extends Thread {

	private MyObject object;

	// 省略构造方法
	@Override
	public void run() {
		super.run();
		object.setName(object.getName()+"BBBB");
		object.methodB();
		
	}

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}
}