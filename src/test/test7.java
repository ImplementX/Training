package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test7 {
    //10进制转换任意进制,并将每位数字存入list中,返回各位数字之和
    public static int transForm(int num, int n){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while(num != 0){
            int remainder = num%n;
            num = num/n;
            list.add(remainder);
        }

        //计算进制转换后所得结果各位数字之和
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }

    //辗转相除,计算两个数的最大公约数
    public static int gcd(int m, int n){
        int r = m % n;
        while (r != 0){
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
        int m = sc.nextInt();
        int sum = 0, div;
        div = m - 2;    // 分子
        for(int i = 2; i < m; i++){
            sum += transForm(m, i);
        }
        System.out.println(sum/gcd(sum, div) + "/" + div/gcd(sum, div));
    }
        }
}