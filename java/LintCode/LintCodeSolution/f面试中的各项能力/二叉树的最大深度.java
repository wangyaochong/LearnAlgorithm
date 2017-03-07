package LintCode.LintCodeSolution.f面试中的各项能力;

import LintCode.LintCodeDefinition.TreeNode;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        // write your code here
        travel(root,0);
        return maxDepth;
    }
    int maxDepth=0;
    public void travel(TreeNode node,int level){
        if(maxDepth<level){
            maxDepth=level;
        }
        if(node!=null){
            travel(node.left,level+1);
            travel(node.right,level+1);
        }
    }
}
