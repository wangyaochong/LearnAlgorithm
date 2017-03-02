package LintCode.LintCodeSolution.d解决面试题的思路;

import LintCode.LintCodeDefinition.DoublyListNode;
import LintCode.LintCodeDefinition.TreeNode;

public class 将二叉查找树转换成双链表 {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        midView(root);
        return head.next;
    }
    DoublyListNode doublyListNode=new DoublyListNode(0);
    DoublyListNode head=doublyListNode;
    public void midView(TreeNode current){
        if(current==null){
            return ;
        }
        midView(current.left);
        doublyListNode.next=new DoublyListNode(current.val);
        doublyListNode.next.prev=doublyListNode;
        doublyListNode=doublyListNode.next;
        midView(current.right);
    }

}
