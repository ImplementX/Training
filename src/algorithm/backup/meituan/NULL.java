package algorithm.backup.meituan;


    public class NULL {

        public static void print(){
            System.out.println("MTDP");
        }
        public static void main(String[] args) {
            System.out.println(String.format("%s",null));
            try{
                ((NULL)null).print();
            }catch(NullPointerException e){
                System.out.println("NullPointerException");
            }
        }
    }

