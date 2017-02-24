package LintCode.LintCodeSolution.d解决面试题的思路;

/**
 * Created by 【王耀冲】 on 【2017/2/24】 at 【18:28】.
 */

import LintCode.LintCodeDefinition.TreeNode;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。

 一个有效的路径，指的是从根节点到叶节点的路径。
 */
public class 二叉树的路径和 {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if(target==0){
            return null;
        }
        travel(root,0,target);
        return pathList;
    }
    List<List<Integer>> pathList=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<Integer>();
    public void travel(TreeNode node, int currentCount,int countTotal){
        if(node==null){
            return ;
        }
        if(currentCount+node.val==countTotal&&node.left==null&&node.right==null){
            List<Integer> newPath=new ArrayList<Integer>();
            for (Integer integer : path) {
                newPath.add(integer);
            }
            newPath.add(node.val);
            pathList.add(newPath);
        }
        path.add(node.val);
        travel(node.left ,node.val+currentCount,countTotal);
        travel(node.right,node.val+currentCount,countTotal);
        if(path.size()>0){
            path.remove(path.size()-1);
        }
    }
}
