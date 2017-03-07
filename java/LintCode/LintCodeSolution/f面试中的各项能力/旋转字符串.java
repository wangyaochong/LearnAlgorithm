package LintCode.LintCodeSolution.f面试中的各项能力;

import java.util.Arrays;

public class 旋转字符串 {
    public void rotateString(char[] str, int offset) {
        if(str.length==0){
            return ;
        }

        char[] charBefore=new char[str.length];
        for(int i=0;i<str.length;i++){
            charBefore[i]=str[i];
        }

        for(int i=0;i<str.length;i++){
            str[(i+offset)%str.length]=charBefore[i];
        }
    }
}
