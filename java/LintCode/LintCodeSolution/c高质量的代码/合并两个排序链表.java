package LintCode.LintCodeSolution.c高质量的代码;

import LintCode.LintCodeDefinition.ListNode;

/**
 * Created by 【王耀冲】 on 【2017/2/23】 at 【17:14】.
 */
public class 合并两个排序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head=new ListNode(0);
        ListNode flag=head;
        ListNode tmp=null;
        while(l1!=null||l2!=null){
            if(l1==null){//如果l1没有了，只加入l2
                l1=l2;
                l2=null;
            }
            if(l1!=null&&l2!=null&&l1.val>l2.val){//当两个都不为null，且l1>l2，则交换两个指针
                tmp=l1;
                l1=l2;
                l2=tmp;
            }
            flag.next=l1;
            flag=flag.next;
            l1=l1.next;
        }
        return head.next;
    }
}
