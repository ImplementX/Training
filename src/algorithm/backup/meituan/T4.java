package algorithm.backup.meituan;

import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(LCS(s1,s2));


    }

    public static int LCS(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0)
            return 0;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int start1 = -1;
        int start2 = -1;
        int[][] results = new int[str2.length][str1.length];
        //最大长度
        int maxLength = 0;
        int compareNum = 0;
        for(int i=0;i<str1.length;i++){
            results[0][i] = (str2[0] == str1[i] ? 1 : 0);
            compareNum++;
            for(int j=1;j<str2.length;j++){
                results[j][0] = (str1[0] == str2[j] ? 1 : 0);
                if(i>0 && j>0){
                    if(str1[i] == str2[j]){
                        results[j][i] = results[j-1][i-1] + 1;
                        compareNum++;
                    }
                }
                if(maxLength < results[j][i]){
                    maxLength = results[j][i];
                    start1 = i - maxLength + 2;
                    start2 = j - maxLength + 2;
                }
            }
        }
        System.out.println("比较次数" + (compareNum+str2.length) + "，s1起始位置：" + start1 + "，s2起始位置：" + start2);
        return maxLength;
    }
}
