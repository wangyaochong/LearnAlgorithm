package LintCode.LintCodeSolution.f面试中的各项能力;

public class 翻转字符串 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        String result="";
        for (int i = split.length-1 ;i>=0;i-- ){
            result+=split[i]+' ';
        }
       return  result.trim();
    }
}
