package LintCode.LintCodeSolution.c高质量的代码;

/**
 * Created by 【王耀冲】 on 【2017/2/23】 at 【17:06】.
 */

import LintCode.LintCodeDefinition.ListNode;

/**
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 */
public class 删除链表中倒数第n个节点 {
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode tail=head;
        int count=0;
        while(count<=n){
            if(tail==null){
                return head.next;//如果是null，则正好删除第一个节点
            }
            tail=tail.next;
            count++;
        }
        ListNode flag=head;
        while(tail!=null){
            tail=tail.next;
            flag=flag.next;
        }
        flag.next=flag.next.next;
        return head;
    }
}
