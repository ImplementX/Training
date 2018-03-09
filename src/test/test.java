package test;

public class test {

	public static void main(String[] args) {

		// 方法一
		 String s = "010030    99999 20130109 23.6 8 16.4 8 1015.3 8 9999.9 0 18.3 8 15.8 8 33.0 999.9 31.5* 14.9 0.00H 1.6 010000";
		 //String s1 = new String(sb);
		 String s1 = "";
		String[] s2 = s.split(" ");
		s1 = s1 +s2[0];
		 for(int i = 1;i<s2.length-1;i++){
		if(!s2[i].isEmpty()){
		System.out.println("|"+s2[i]+"|");
		s1= s1+","+s2[i];}
//		 if(sb.charAt(i)==' '&&sb.charAt(i+1)!=' ')
//		 sb.replace(i, i+1, ",");
		 }
		
		
		
		

		 System.out.println(s1);

		// 方法二
//		String s = "010030 99999  20130109    23.6  8    16.4  8  1015.3  8  9999.9  0   18.3  8   15.8  8   33.0  999.9    31.5*   14.9   0.00H   1.6  010000";
//		char[] c = new char[s.length()];
//		
//		for (int i = 0; i < s.length(); i++) {
//			c[i] = s.charAt(i);
//		}
//		
//		
//		for (int i = 0; i < s.length(); i++) {
//			if (c[i] == ' ' && c[i + 1] != ' ') {
//				c[i] = ',';
//			}
//		}
//		
//		String s1 = new String(c);
//		s1 = s1.replace(" ", "");
//		System.out.println(s1);
	}


}

class Professor implements Cloneable {
    String name;
    int age;
 
    Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
