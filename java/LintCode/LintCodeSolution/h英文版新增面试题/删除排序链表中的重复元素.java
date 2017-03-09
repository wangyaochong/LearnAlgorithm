package LintCode.LintCodeSolution.h英文版新增面试题;

import LintCode.LintCodeDefinition.ListNode;

public class 删除排序链表中的重复元素 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret=head;
        while(ret!=null&& ret.next!=null){
            while(ret.next!=null&&ret.val==ret.next.val){
                ret.next=ret.next.next;
            }
            ret=ret.next;
        }
        return head;
    }
}
