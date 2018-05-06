package algorithm.backup.meituan;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Double n = sc.nextDouble();
        System.out.println((int) Math.pow(2, n - 1));
    }
}
