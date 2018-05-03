package algorithm.Prime;


public class PrimeNumber {
    public static void main(String[] args) {
        primeList1(100);
        System.out.println("");
        primeList2(100);
    }
    //素数判断
    public static boolean isPrime(int num){
            if(num<=2){
                return true;
            }
            for(int temp = 2; temp < Math.sqrt(num)+1; temp++){
                if(num%temp==0){
                    return false;
                }
            }
            return true;
    }
    //穷举法
    public static void primeList1(int count){
         for (int i = 1; i <= 100; i++){
            if(isPrime(i)){
                System.out.print(i+"\t");
            }
        }
    }
    //筛选法
    public static void primeList2(int count){
        boolean[] primeList = new boolean[count+1];

        for (int index = 0; index <= count; primeList[index++] = true);

        int max =(int) Math.sqrt(count)+1;

        for(int i = 2; i <= max; i++){
            if(isPrime(i)){
                primeList[i] = true;
                for(int j = 2; j*i <= count; j++ ){
                    primeList[j*i] = false;
                }
            }

        }

        for(int k=1;k<count;k++){
            if(primeList[k]){
                System.out.print(k+"\t");
            }
        }


    }
}
