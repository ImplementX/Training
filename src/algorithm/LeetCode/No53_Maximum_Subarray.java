package algorithm.LeetCode;

import com.sun.xml.internal.ws.message.stream.PayloadStreamReaderMessage;

//最大子序列和问题
public class No53_Maximum_Subarray {

    public static void main(String[] args) {
        int[] a = {1,-2,4};
        int result;
//        result = maxSumRec(a,0,a.length-1);
        result = maxSubArray(a);
        System.out.println(result);


    }



    
    public static int maxSubArray(int[] nums){
        int max=nums[0], thisSub=nums[0];
        for (int i=1;i<nums.length;++i){
            
            thisSub= Math.max(thisSub+nums[i],nums[i]);
            max=Math.max(max, thisSub);
            
        }
        return max;
    }
}
