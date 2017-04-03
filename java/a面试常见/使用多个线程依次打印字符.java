package a面试常见;

import a面试常见.MyClass.MyTask;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【22:05】.
 */

public class 使用多个线程依次打印字符 {
    @Test
    public void testMultiThread() throws InterruptedException {
        ArrayList<MyTask> tasks=new ArrayList<>();
        for(int i=0;i<26;i++){
            tasks.add(new MyTask((char)('a'+i)));
        }
        ArrayList<Thread> threads=new ArrayList<>();
        for(int i=0;i<26;i++){
            tasks.get(i).targetToNotify=tasks.get((i+1)%26).taskString;
            threads.add(new Thread(tasks.get(i)));
        }
        for(int i=0;i<26;i++){
            threads.get(i).start();
            Thread.sleep(50);
        }

    }
}
