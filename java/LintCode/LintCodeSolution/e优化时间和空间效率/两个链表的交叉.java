package LintCode.LintCodeSolution.e优化时间和空间效率;

import LintCode.LintCodeDefinition.ListNode;

import java.util.ArrayList;
import java.util.Map;

public class 两个链表的交叉 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> path=new ArrayList<ListNode>();
        while(headA!=null){
            path.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if (path.contains(headB)) {
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
