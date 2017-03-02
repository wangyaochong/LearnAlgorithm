package LintCode.LintCodeSolution.d解决面试题的思路;

import LintCode.LintCodeDefinition.TreeNode;

import java.util.ArrayList;

public class 二叉树的后序遍历 {
    ArrayList<Integer> path=new ArrayList<Integer>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        postView(root);
        return path;
    }
    public void postView(TreeNode root){
        if(root==null){
            return ;
        }
        postView(root.left);
        postView(root.right);
        if(root!=null){
            path.add(root.val);
        }
    }
}
