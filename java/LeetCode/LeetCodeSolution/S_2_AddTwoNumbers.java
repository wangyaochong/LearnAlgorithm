package LeetCode.LeetCodeSolution;

import LeetCode.LeetCodeDefinition.ListNode;
import Util.UtilDisplay;
import Util.UtilListNode;
import org.junit.Test;

public class S_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(l1.val+l2.val);
        ListNode l1Current=l1;
        ListNode l2Current=l2;
        ListNode currentNode=new ListNode(0);
        ListNode retHead=currentNode;
        int jinwei=0;
        int yushu=0;
        while(l1Current!=null&&l2Current!=null){
            yushu=(l1Current.val+l2Current.val+jinwei)%10;//找出余数
            currentNode.val=yushu;//设置每个节点的值
            jinwei=(l1Current.val+l2Current.val+jinwei)/10;//找出进位
            if(l1Current.next!=null||l2Current.next!=null||jinwei!=0){
                //只要有一个还没到头，或者有进位
                currentNode.next=new ListNode(0);//分配空间
            }
            currentNode=currentNode.next;//向后移动一格
            l1Current=l1Current.next;
            l2Current=l2Current.next;
        }
        l1Current=l1Current==null?l2Current:l1Current;//都用l1Current来表示剩余的node
        while(l1Current!=null){
            yushu=(l1Current.val+jinwei)%10;//找出余数
            currentNode.val=yushu;
            jinwei=(l1Current.val+jinwei)/10;//找出进位
            if(l1Current.next!=null||jinwei!=0){
                //只要有一个还没到头，或者有进位
                currentNode.next=new ListNode(0);//分配空间
            }
            currentNode=currentNode.next;//移动一格
            l1Current=l1Current.next;
        }
        if(jinwei!=0){
            currentNode.val=jinwei;
        }
        return retHead;
    }
    @Test
    public void testAddTwoNumbers(){
        ListNode listNode = UtilListNode.parseArrayToListNodeList_leetCode(new int[]{1, 2, 3, 4,5});
        ListNode listNode2 = UtilListNode.parseArrayToListNodeList_leetCode(new int[]{5,6, 2, 3});
        ListNode result = addTwoNumbers(listNode, listNode2);
        UtilDisplay.display(result);
    }

}
