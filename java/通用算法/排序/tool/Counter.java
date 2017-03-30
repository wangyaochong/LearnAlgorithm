package 通用算法.排序.tool;

public class Counter {
    private static int count=0;
    public static void AddOne(){
        count++;
    }
    public static int getCount(){
        return count;
    }
    public static void Display(){
        System.out.println("count = "+count);
    }
}
