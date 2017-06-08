package 通用算法.排序.practice;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/6/8】 at 【14:59】.
 */
public class Main {
    public boolean validWordAbbreviation(String word, String abbr){
        // code here
        int abbrLoc=0;
        int wordLoc=0;
        while(abbrLoc<abbr.length()){
            String num="";
            if(!(abbrLoc<abbr.length()&& abbr.charAt(abbrLoc)>='0' && abbr.charAt(abbrLoc)<='9' ) ){
                if(wordLoc<word.length()&& word.charAt(wordLoc)==abbr.charAt(abbrLoc)){
                    abbrLoc++;
                    wordLoc++;
                    if(wordLoc>word.length()){
                        return false;
                    }
                }else{
                    return false;
                }
            }
            while(abbrLoc<abbr.length()&&abbr.charAt(abbrLoc)>='0' && abbr.charAt(abbrLoc)<='9' ){
                num+=abbr.charAt(abbrLoc);
                if(num.startsWith("0")){
                    return false;
                }
                abbrLoc++;
            }
            if(!num.equals("")){
                wordLoc+=Integer.parseInt(num);
                if(wordLoc>word.length()){
                    return false;
                }
            }
        }
        if(wordLoc!=word.length()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        String s = jin.next(), abbr = jin.next();

        System.out.println(new Main().validWordAbbreviation(s, abbr));
    }
}
