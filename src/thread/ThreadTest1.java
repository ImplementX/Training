package thread;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ThreadTest1 {
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException  {
		
		
			
			
		
		
		
		
		
		
		
	
		
		
		
		Thread t1 = new Thread1(1);
		
		Thread t2 = new Thread1(2);
//		printMethod(t1.getClass().getSuperclass());
//		printFields(t1.getClass().getSuperclass());
	
		
		t1.start();
		t1.join();
		t2.start();
//		for(int i=0;i<=10;i++){
//			System.out.println("main"+i);
//		}
		Mythread mt= new Mythread();
//		Thread t3 = new Thread(mt);
//		t3.start();
	}
	
	public static void printMethod(Class cl) throws ClassNotFoundException {
		
		
		Method[] tmethods =cl.getDeclaredMethods();
		for(Method m:tmethods){
			Class returntype = m.getReturnType();
			String name = m.getName();
			String modifier = Modifier.toString(m.getModifiers());
			if(modifier.length()>0){
				System.out.print(modifier+" ");
			}
			System.out.print(returntype.getTypeName()+" "+name+" (");
			Class[] paramtypes = m.getParameterTypes(); 	
			for (int j = 0; j < paramtypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramtypes[j].getName());
			}
			System.out.println(");");
	}
	
	}
	
	public static void printFields(Class cl) throws ClassNotFoundException {
		
		Field[] fields=cl.getDeclaredFields();
		for(Field field:fields){
			Class type =field.getType();
			String name = field.getName();
			System.out.println(type+" "+name);
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	
		
		
	}
		
}
