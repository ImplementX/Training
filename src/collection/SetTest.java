package collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class SetTest {

	
	
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(

		);
		 set.add("abc");
		 set.add("def");
		 set.add("ghi");
		 set.add("zxc");
		 set.add("qwe");
		 set.add("jkl");
	
		 Iterator<String> it = set.iterator();
		 while(it.hasNext()){
		 System.out.println(it.next());
		 }
		 }
}

