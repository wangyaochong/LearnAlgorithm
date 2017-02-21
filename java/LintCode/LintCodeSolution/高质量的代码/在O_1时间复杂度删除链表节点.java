package LintCode.LintCodeSolution.高质量的代码;

import LintCode.LintCodeDefinition.ListNode;

/**
 * Created by 【王耀冲】 on 【2017/2/21】 at 【17:52】.
 */
public class 在O_1时间复杂度删除链表节点 {
    public void deleteNode(ListNode node) {
        // write your code here
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
