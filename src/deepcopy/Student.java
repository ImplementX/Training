package deepcopy;

public class Student {
    String name;// 常量对象。
    int age;
    Professor p;// 学生1和学生2的引用值都是一样的。

    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    public Object clone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }

        return o;
    }
}
