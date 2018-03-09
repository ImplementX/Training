package generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {


    public static void main(String[] args) {
        //List<? extends E>
        //集合中的实例T全部为E的子类型
        //不能添加
        //多种实例时强制转换为E
        List<? extends Number> list = new ArrayList<>();
//        list.add(4.0);//编译错误
//        list.add(3);//编译错误


        //对于List<? super E>其list中存放的都是E的父类型元素（包括E）
        // 我们在向其添加元素时，只能向其添加E的子类型元素（包括E类型）
        // 这样在编译期间将其强制转换为E类型时是类型安全的，因此可以添加元素
        List<? super Number> list1 = new ArrayList<>();
        list1.add(4.0);
        list1.add(3.0);
        Number n = new Integer(3);
        list1.add(n);
        System.out.println(list1);

        System.out.println(  list1.get(1));

    }
//    T 必须实现Comparable和Serializable
    public <T extends Comparable & Serializable> List<T> returnList(T t) {
        return null;
    }


}	
