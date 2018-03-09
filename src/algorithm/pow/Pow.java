package algorithm.pow;

//整形幂运算
public class Pow {
    public static long pow(long x, int n){
       if(n==0){
           return 1;
       }
       if(n == 1){
           return x;
       }

       if(isEven(n)){
           return pow(x*x, n/2);
       }else{
           return pow(x*x,n/2)*x;
       }


    }


    public static Boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        long result = pow(212,15);
        System.out.println(result);
    }
}
