package Util;

import LeetCode.LeetCodeDefinition.ListNode;

public class UtilListNode {
    public static ListNode parseArrayToListNodeList(int [] input){
        ListNode listNode=new ListNode(0);
        ListNode currentNode=listNode;
        for(int i=0;i<input.length;i++){
            currentNode.val=input[i];
            if(i+1!=input.length)//如果当前不是最后一个
                currentNode.next=new ListNode(0);
            currentNode=currentNode.next;
        }
        return listNode;
    }
}
