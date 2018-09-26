package algorithm.LintCode;

import java.util.ArrayList;

public class No_4 {

    public int nthUglyNumber(int n) {




        // write your code here
        int p2 = 0, p3 = 0, p5 = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        for(int i = 0; i < n; i++ ){
            int currentMax = nums.get(1);
            while(nums.get(i) * 2 <= currentMax){
                p2++;
            }
            while(nums.get(i) * 3 <= currentMax){
                p3++;
            }
            while(nums.get(i) * 5 <= currentMax){
                p5++;
            }




        }



    }

}
