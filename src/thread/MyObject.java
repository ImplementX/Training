package thread;
public class MyObject {
	private String name;
	private String age;
	
	
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public MyObject(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}



	synchronized public void methodA() {
    	for (int i = 0; i < 2; i++) {
    		 System.out.println("methodA:"+this.name+ "   "+ this.age);
		}
       
    }

    synchronized public void methodB() {
        //do some other thing
    	for (int i = 0; i < 2; i++) {
    		 System.out.println("methodB:"+this.name+ "   "+ this.age);
		}
       
    }
}