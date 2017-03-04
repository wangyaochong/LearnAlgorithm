package LintCode.LintCodeSolution.d解决面试题的思路;

import java.util.Stack;

public class 带最小值操作的栈 {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.size()==0){
            minStack.push(number);
            return ;
        }
        if(minStack.peek()>=number){//当最小值栈的顶部大于等于number，则用新值更新minStack
            minStack.push(number);
        }else{//如果number大于记录的最小值，则用minStack的最小值更新
            minStack.push(new Integer(minStack.peek()));
        }

    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
