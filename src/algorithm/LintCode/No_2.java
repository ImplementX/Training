package algorithm.LintCode;

public class No_2 {
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n  /= 5;

        }
        return sum;
    }
}
