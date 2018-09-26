package algorithm.LintCode;

public class No_3 {
    public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for( int i = k; i <= n; i++ ){
            cnt += numberCount(i,k);
        }
        return cnt;
    }



    public int numberCount( int i, int k ){
        if(  i == 0 && k == 0 ){
            return 1;
        }
        int cnt = 0;
        while ( i > 0 ){
            if( i % 10 == k){
                cnt ++ ;
            }
            i /= 10;
        }
        return cnt;
    }
}
