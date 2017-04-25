package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.Stack;

public class S_32_LongestValidParentheses {
    public int longestValidParentheses(String input){//()(())输出6
        int max=0;
        int current=0;
        int lastValidPos=0;
        int lastCurrent=0;
        Stack<Character> cache=new Stack<Character>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                cache.push('(');
            }
            if(input.charAt(i)==')'){
                if(cache.size()>0&& cache.peek()=='('){
                    current+=2;
                    cache.pop();
                }
                if(cache.size()==0) {//如果栈里面没有字符了，说明一轮连续的结束了
                    if(i-lastValidPos==current){//如果是连续的，加上上一次的结果
                        current=lastCurrent+current;
                    }
                    if(max<current){
                        max=current;
                    }
                    lastValidPos=i;
                    lastCurrent=current;
                    current=0;
                }
                if(cache.size()!=0){

                }
            }
        }
        return max;
    }
    @Test
    public void testLongestValidParentheses(){
        System.out.println(longestValidParentheses("(()()(((((()()"));
    }
}
