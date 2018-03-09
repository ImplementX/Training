package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test8 {
	public static int f(int x) {
		int sum = 0;
		ArrayList<Integer> num = new ArrayList<>();
		while (x != 0) {
			num.add(x % 10);
			x = x / 10;
		}
		for (int i = 0; i < num.size(); i++) {
			sum += num.get(i);
		}

		return sum;
	}

	public static int g(int x) {
		int sum = 0;
		while (x != 0) {
			sum+= x % 2;
			x = x / 2;
		}
		return sum;


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int result=0;
		if(x>=100000||x<0)
			return;
		while (x > 0) {
			if (f(x) == g(x)) {
				System.out.println(x+" "+f(x)+" "+g(x));
				result++;
			}
			x--;
		}
		System.out.println(result);
	}
}
