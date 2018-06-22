package LeetCode.LeetCodeSolution;

import LeetCode.LeetCodeDefinition.TreeNode;

public class S_112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root!=null&&sum==root.val&&root.left==null&&root.right==null){
            return true;
        }
        if(root==null){
            return false;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

}
