package inner_class;

import javax.xml.transform.Source;

public class Outer {

    private String value = "outer value here";



    private class Inner {
        private String value ="inner value here";
        public void innerPrint(){
            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer.this.value);


        }


    }

    public void  printValue(){
        System.out.println(value);
        System.out.println(this.value);
        Inner inner = new Inner();
        inner.innerPrint();
    }
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.printValue();

    }

}
