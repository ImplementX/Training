package thread;

public class ThreadA  extends Thread{
	   private MyObject object;

		//省略构造方法
	     @Override
	     public void run() {
	         super.run();
	       
	         object.methodA();
	         for (int i = 0; i < 2; i++) {
//	       		 System.out.println("methodA:"+object.getName());
	    		}
	     }
	     
		 public ThreadA(MyObject object) {
				// TODO Auto-generated constructor stub
				 this.object=object;
				 
			}
	     
}
