package a面试常见;

import a面试常见.MyClass.MyTask;
import org.junit.Test;
/**
 * Created by【王耀冲】on 【2017/4/2】 at 【16:17】.
 */

public class 使用三个线程依次打印abc各10次 {
    @Test
    public void testMultiThread() throws InterruptedException {
        MyTask t1=new MyTask("a",null);
        MyTask t2=new MyTask("b",null);
        MyTask t3=new MyTask("c",null);
        t1.targetToNotify=t2.taskString;
        t2.targetToNotify=t3.taskString;
        t3.targetToNotify=t1.taskString;
        Thread a=new Thread(t1);
        Thread b=new Thread(t2);
        Thread c=new Thread(t3);
        a.start();
        Thread.sleep(50);
        b.start();
        Thread.sleep(50);
        c.start();
    }

    class TestWait implements Runnable{
        Object targetToNotify;
        public TestWait(Object o){
            this.targetToNotify=o;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                synchronized (targetToNotify){
                    targetToNotify.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void TestNotify(){
        Integer a=1;
        Thread test=new Thread(new TestWait(a));
        test.start();
        try {
            synchronized (a){
                a.wait();
                System.out.println("hello");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
