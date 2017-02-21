package LintCode.LintCodeSolution.面试需要的基础知识;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by 【王耀冲】 on 【2017/2/10】 at 【16:23】.
 */
public class 用栈实现队列 {
    private Stack<Integer> stack1=new Stack<Integer>();
    private Stack<Integer> stack2=new Stack<Integer>();
    public void push(int element) {
        stack1.push(element);
    }
    public int pop() {
        Stack<Integer> emptyStack=stack2;
        Stack<Integer> sizeStack=stack1;
        while(sizeStack.size()>0){
            emptyStack.push(sizeStack.pop());
        }
        int result=emptyStack.pop();
        while(emptyStack.size()>0){
            sizeStack.push(emptyStack.pop());
        }
        return result;
    }
    public int top() {
        Stack<Integer> emptyStack=stack2;
        Stack<Integer> sizeStack=stack1;
        while(sizeStack.size()>0){
            emptyStack.push(sizeStack.pop());
        }
        int result=emptyStack.peek();
        while(emptyStack.size()>0){
            sizeStack.push(emptyStack.pop());
        }
        return result;
    }
    @Test
    public void testStackQueue(){
        push(1);
        push(2);


    }
}
