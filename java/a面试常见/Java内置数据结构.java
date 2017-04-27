package a面试常见;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【8:21】.
 */
public class Java内置数据结构 {
    @Test
    public void testDeque(){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }
    public static void main(String[] args) {

    }
}
