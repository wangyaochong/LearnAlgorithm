package a面试常见.MyClass;

import java.lang.annotation.Target;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【22:06】.
 */
public class MyTask implements Runnable{
    public Object taskString;
    public Object targetToNotify;
    public MyTask(Object input,Object targetToNotify){
        this.taskString=input;
        this.targetToNotify=targetToNotify;
    }
    public MyTask(Object input){
        this(input, null);
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(taskString+"-->"+i);
            try {
                synchronized (targetToNotify){
                    targetToNotify.notify();
                }
                synchronized (taskString){
                    taskString.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
