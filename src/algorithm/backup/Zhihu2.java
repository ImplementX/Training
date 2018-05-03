package algorithm.backup;

import java.util.Scanner;
import java.math.BigInteger;


public class Zhihu2 {
    public static void main(String[] args) {
        /* code */
        BigInteger count = new BigInteger("0");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();



        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < x; i++) {
            sb.append("0");
        }
        BigInteger number = new BigInteger(sb.toString());

        while (number.toString().length() == x) {

            if (isMeNumber(number)) {
                count = count.add(new BigInteger("1"));
            }
            number = number.add(new BigInteger("1"));
        }

        //输出除以2999的余数
        System.out.println(count.mod(new BigInteger("2999")));

    }


    public static boolean isMeNumber(BigInteger number) {

        int ji = 1;
        int ou = 1;
        boolean flag = true;
        String s = number.toString();
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
//            System.out.println(x+" "+s.charAt(i));
            if (flag) {
                ji = ji * x;
            } else {
                ou = ou * x;
            }

            flag = !flag;

        }


        if (ji == ou) {
            System.out.println(s);
            System.out.println("------------------------------");
            return true;
        } else {
            return false;
        }
    }
}