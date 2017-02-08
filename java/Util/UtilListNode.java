package Util;


public class UtilListNode {
    public static  LeetCode.LeetCodeDefinition.ListNode parseArrayToListNodeList_leetCode(int [] input){
        LeetCode.LeetCodeDefinition.ListNode listNode=new LeetCode.LeetCodeDefinition.ListNode(0);
        LeetCode.LeetCodeDefinition.ListNode currentNode=listNode;
        for(int i=0;i<input.length;i++){
            currentNode.val=input[i];
            if(i+1!=input.length)//如果当前不是最后一个
                currentNode.next=new LeetCode.LeetCodeDefinition.ListNode(0);
            currentNode=currentNode.next;
        }
        return listNode;
    }

    public static LintCode.LintCodeDefinition.ListNode parseArrayToListNodeList_lintCode(int [] input){
        LintCode.LintCodeDefinition.ListNode listNode=new LintCode.LintCodeDefinition.ListNode(0);
        LintCode.LintCodeDefinition.ListNode currentNode=listNode;
        for(int i=0;i<input.length;i++){
            currentNode.val=input[i];
            if(i+1!=input.length)//如果当前不是最后一个
                currentNode.next=new LintCode.LintCodeDefinition.ListNode(0);
            currentNode=currentNode.next;
        }
        return listNode;
    }
}
