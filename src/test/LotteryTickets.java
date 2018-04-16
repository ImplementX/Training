package test;

import java.util.Scanner;
import java.util.Vector;

public final class LotteryTickets {
public static void main(String[] args) {
//	Integer first = new Integer(3);
//	Integer second = 3;
//	int three = 3;
//	Math.round(3.14);
//	System.out.println(Math.round(3.74));
//	System.out.println(first==three);
	int count1 = 0;
	int count2 = 0;
	for(int i=0;i<100;i++){
		count1 = count1++;
		count2 = ++count2;
	}

	System.out.println("count1="+count1);

	System.out.println("count2="+count2);

}
}
