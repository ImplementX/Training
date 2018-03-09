package algorithm.LeetCode;

public class No69_Sqrt_x {



    public int mySqrt1(int x) { // Time: O(logn) Space: O(1)--binary search
        if(x <= 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            long mid = (high - low) /2 + low;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid -1;
            }
        }
        if (high * high < x) {
            return (int) high;
        } else {
            return (int) low;
        }


    }



//牛顿迭代法  Time: Unknown Space: O(1)
    public int mySqrt(int x) {

        long res = x;

        while (res * res > x) {
            res = (res + x /res) / 2;
        }
        return (int) res;
    }
}
