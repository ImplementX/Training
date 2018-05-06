package algorithm.backup.meituan;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0;i< n ;i++){
            nums[i] = sc.nextInt();

        }
        int max_area = 0;
        int min_height = nums[0];
        for(int i = 0; i< n;i++){
            min_height = nums[i];
            for (int j=i; j<n;j++){
                min_height = Math.min(nums[j],min_height);
                int area = min_height*(j-i+1);

                max_area =Math.max(area,max_area);

            }




        }
        System.out.println(max_area);

    }
}
