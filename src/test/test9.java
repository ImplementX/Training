package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;

        a = sc.nextInt();
        b = sc.nextInt();
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        if (a < 0 || b < 0 || a > 10000 || b > 10000)
            return;
        for (int i = 0; i < a; i++) {
            num1.add(sc.nextInt());
        }
        for (int i = 0; i < b; i++) {
            num2.add(sc.nextInt());

        }
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(num1);
        set.addAll(num2);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) {
                System.out.print(" ");
            }
        }
        int xa;
        System.out.println(a);

    }
}
