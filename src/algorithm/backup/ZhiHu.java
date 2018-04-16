package algorithm.backup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 题目名称：课程大作业

时间限制：5000ms

题目描述：小王计算机学院三年级本科生。他平时比较贪玩，这个学期就要结束了，每个课程大作业的截止时间也快到了，可是小王还没有开始做。
每一门课程都有一个课程大作业，每个课程大作业都有截止时间。如果提交时间超过截止时间X天，那么他将会被扣掉X分。
对于每个大作业，小王要花费一天或者若干天来完成。他不能同时做多个大作业，只有他完成了当前的项目，才可以开始一个新的项目。
小王希望你可以帮助他规划出一个最好的办法(完成大作业的顺序)来减少扣分。

输入描述：输入包含若干测试样例。

输入的第一行是一个正整数T，代表测试样例数目。

对于每组测试样例，第一行为正整数N（1 <= N <= 15）代表课程数目。

接下来N行，每行包含一个字符串S（不多于50个字符）代表课程名称和两个整数D（代表大作业截止时间）和C（完成该大作业需要的时间）。

注意所有的课程在输入中出现的顺序按照字典序排列。


输出描述：对于每组测试样例，请输出最小的扣分以及相应的课程完成的顺序。

如果最优方案有多个，请输出字典序靠前的方案。

示例1

输入

2

3

Computer 3 3

English 20 1

Math 3 2

3

Computer 3 3

English 6 3

Math 6 3

输出

2

Computer

Math

English

3

Computer

English

Math
(Hint：第二个测试样例, 课程完成顺序Computer->English->Math 和 Computer->Math->English 都会造成3分罚分, 但是我们选择前者,因为在字典序中靠前)*/
class Course implements Comparable<Course>{
    public String name;
    public int deadLine;
    public int needTime;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", deadLine=" + deadLine +
                ", needTime=" + needTime +
                '}';
    }

    @Override
    public int compareTo(Course o) {
        if(this.deadLine > o.deadLine) {
            return 1;
        }
        else if(this.deadLine < o.deadLine){
            return -1;
        }
        else {
            if (this.needTime > o.needTime) {
                return 1;
            } else if (this.needTime > o.needTime) {
                return -1;
            } else {
                return this.name.compareTo(o.name);

            }
        }


    }

    public Course(String name, int deadLine, int needTime) {
        this.name = name;
        this.deadLine = deadLine;
        this.needTime = needTime;
    }
}

public class ZhiHu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbs = sc.nextInt();
        for(int i = 0; i < numbs; i++){
            ArrayList<Course> list = new ArrayList<>();
            int courses = sc.nextInt();
            for(int j = 0; j < courses; j++){
                String name = sc.next();
                int deadLine = sc.nextInt();
                int needTime = sc.nextInt();
                list.add(new Course(name,deadLine,needTime));
            }
            func(list);
    }
 }

    public static void func(ArrayList<Course> list){
        int usedTime = 0;
        int score = 0;

        Collections.sort(list);
        for(Course c : list) {
            usedTime += c.needTime;
            if(usedTime > c.deadLine) {
                score += (usedTime - c.deadLine);
            }
        }
        System.out.println(score);
        for(Course c : list){
            System.out.println(c.name);
        }
    }
}
