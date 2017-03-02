package LintCode.LintCodeSolution.d解决面试题的思路;

/**
 * Created by 【王耀冲】 on 【2017/2/27】 at 【17:48】.
 */

import LintCode.LintCodeDefinition.TreeNode;

/**
 * 深度复制一个二叉树。给定一个二叉树，返回一个他的 克隆品 。
 */
public class 克隆二叉树 {
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if(root==null){
            return null;
        }
        TreeNode target=new TreeNode(root.val);
        clone(root,target);
        return target;
    }
    public void clone(TreeNode origin,TreeNode target){
        target.val=origin.val;
        if(origin.left!=null){
            target.left=new TreeNode(0);
            clone(origin.left,target.left);
        }
        if(origin.right!=null){
            target.right=new TreeNode(0);
            clone(origin.right,target.right);
        }
    }
}
