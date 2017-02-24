package LintCode.LintCodeSolution.b面试需要的基础知识;

import LintCode.LintCodeDefinition.ListNode;
import Util.UtilDisplay;
import Util.UtilListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by 【王耀冲】 on 【2017/2/8】 at 【17:13】.
 */

/**
 * 样例给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 */
public class 翻转链表 {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode tmp = new ListNode(0);
        ListNode retHead = tmp;
        Stack<ListNode> s = new Stack<ListNode>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        while (s.size() != 0) {
            tmp.next = s.pop();
            tmp = tmp.next;
        }
        tmp.next=null;
        return retHead.next;
    }

    @Test
    public void testReverse() {
        int[] data = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = UtilListNode.parseArrayToListNodeList_lintCode(data);
        ListNode reverse = reverse(listNode);
        UtilDisplay.display(reverse);
    }

}
