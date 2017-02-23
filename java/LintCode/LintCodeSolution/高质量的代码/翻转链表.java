package LintCode.LintCodeSolution.高质量的代码;

import LintCode.LintCodeDefinition.ListNode;

/**
 * Created by 【王耀冲】 on 【2017/2/23】 at 【17:31】.
 */
public class 翻转链表 {
    public ListNode reverse(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode tmp=head.next;
        ListNode tmp2;
        head.next=null;//翻转链表，头结点的next肯定是null，

        while(tmp!=null){//一步一步倒着走就行了
            tmp2=tmp;
            tmp=tmp.next;
            tmp2.next=head;
            head=tmp2;
        }

        return head;
        // write your code here
    }
}
