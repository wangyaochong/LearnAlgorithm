package Util;

import LeetCode.LeetCodeDefinition.ListNode;

import java.util.List;

public class UtilDisplay {
    public static <T> void display(T[] input){
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }
    public static void display(int[] input){
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }
    public static void display(List input){
        for(int i=0;i<input.size();i++){
            System.out.println(input.get(i));
        }
    }
    public static void display(LeetCode.LeetCodeDefinition.ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public static void display(LintCode.LintCodeDefinition.ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
