package thread;

public class Thread1 extends  Thread{
	int id;
	Thread1(int id){
		this.id = id;
	}
	public void run() {
			for(int i=1;i<=10;i++)
				System.out.println("线程"+id+"  "+i);
		}
	
	
}


class Mythread implements Runnable{
	
	public void run() {
		
		for(int i=30;i>=1;i--)
			System.out.println("线程3  "+i);
		//实现该方法
	}
}
