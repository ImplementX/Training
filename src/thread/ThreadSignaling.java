package thread;

public class ThreadSignaling {





	public static void main(String[] args) {
		MyObject object = new MyObject("张三","18");

		// 线程A与线程B 持有的是同一个对象:object
		ThreadA a = new ThreadA(object);
		ThreadB b = new ThreadB(object);
		
		a.start();
		b.start();
		
	
	      
	}

}
