package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String name;
		if (args.length > 0)
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			name = in.next();

		}
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println("class " + name);
			
			if (supercl != null && supercl != Object.class)
				System.out.println(" extends" + supercl.getName());
			
			System.out.println("\n{\n---------------");
			printConstructors(cl);
			System.out.println("---------------");
			printMethods(cl);
			System.out.println("---------------");
			printFields(cl);
			System.out.println("}");
			
			
			
			
			
			
			
//			-----------------------------------
			Item item = new Item();
			item.setName("12321321");
			 
			Class itemclass = Class.forName(name);
			Field[] fields = itemclass.getDeclaredFields();
			for(Field field:fields){
				//field.setAccessible(true);
				System.out.println("++++++++++++++++++++++++++++"+field.get(item)+"+++++++++++++++++++++++");
			}		
			  Method[] methods=itemclass.getDeclaredMethods();
			  for(Method method:methods){
				  if(!method.getReturnType().toString().equals("void")){
					  	Object obj = method.invoke(item);
					  	if(obj!=null){
					  		System.out.println(obj);
					  	}
				  
				  }
			  }
			//--------------------------------------------------------
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printConstructors(Class cl) {
		// TODO Auto-generated method stub
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.println("   ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(name + "(");
			Class[] paramType = c.getParameterTypes();
			for (int j = 0; j < paramType.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramType[j].getName());
			}
			System.out.println(");");
		}
	}

	private static void printMethods(Class cl) {
		// TODO Auto-generated method stub
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class reType = m.getReturnType();
			String name = m.getName();
			System.out.println("   ");
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(reType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		
		for (Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.println("   ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}

	}

}
