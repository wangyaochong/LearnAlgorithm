package LintCode.LintCodeSolution.b面试需要的基础知识;

/**
 * Created by 【王耀冲】 on 【2017/2/8】 at 【9:30】.
 */

import org.junit.Test;

/**
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
 * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 * 你的程序还需要返回被替换后的字符串的长度。
 */
public class 空格替换 {

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */

    public int replaceBlank(char[] string, int length) {
        if(string==null){
            return 0;
        }
        int spaceCount=0;
        int changedCount=0;
        for (char c : string) {
            if(c==' '){
                spaceCount++;
            }
        }
        int realLength=length+spaceCount*2;
        int loc=length-1;
        while(loc>=0&&spaceCount>0&&changedCount!=spaceCount){
            if(string[loc]!=' '){
                string[loc+(spaceCount-changedCount)*2]=string[loc];
            }else{
                string[loc+(spaceCount-changedCount)*2]='0';
                string[loc+(spaceCount-changedCount)*2-1]='2';
                string[loc+(spaceCount-changedCount)*2-2]='%';
                changedCount=changedCount+1;
            }
            loc--;
        }
        return realLength;
    }
    @Test
    public void testReplaceBlack(){
        String test="abc abc ";
        char [] testArray=new char[1000];
        for (int i=0;i<test.length();i++){
            testArray[i]=test.charAt(i);
        }
        int i = replaceBlank(testArray, test.length());
        System.out.println(testArray);
        System.out.println(i);
    }
}
