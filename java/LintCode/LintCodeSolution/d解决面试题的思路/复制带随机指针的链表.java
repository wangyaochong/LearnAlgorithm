package LintCode.LintCodeSolution.d解决面试题的思路;

import LintCode.LintCodeDefinition.RandomListNode;

public class 复制带随机指针的链表 {//这道题没讲清楚，没有说随机指针是不是也要进行深度复制，目前这种实现方式，是随机指针并不是深度复制
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        RandomListNode result=new RandomListNode(head.label);
        RandomListNode resultHead=new RandomListNode(0);
        resultHead.next=result;
        while(head!=null){
            result.label=head.label;
            if(head.next!=null){
                result.next=new RandomListNode(0);
            }
            result.random=head.random;
            result=result.next;
            head=head.next;
        }
        return resultHead.next;
    }
}
