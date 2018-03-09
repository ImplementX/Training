package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class test5 {
public static void main(String[] args) {
	double a  = 22222222-1.1;
	int i = 0;
	//System.out.printf("%,(f",a);
	List<Integer> s = new ArrayList<>();
	int[] as= new int[10];
	Arrays.fill(as, 0);
	GregorianCalendar calender = new GregorianCalendar();
	int date = calender.get(calender.DAY_OF_WEEK);
	System.out.println(date);
	
}
}
