package LintCode.LintCodeSolution.d解决面试题的思路;

import LintCode.LintCodeDefinition.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 【王耀冲】 on 【2017/2/27】 at 【17:58】.
 */
public class 二叉树的层次遍历 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> cacheList=new LinkedList<TreeNode>();
        cacheList.add(root);
        cacheList.add(new TreeNode(Integer.MAX_VALUE));
        ArrayList<ArrayList<Integer>> levels=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return levels;
        }
        while(cacheList.size()>1){//当不是只有标志位
            ArrayList<Integer> level=new ArrayList<Integer>();
            while(cacheList.get(0).val!=Integer.MAX_VALUE){//当没有到标志位
                TreeNode tmp=cacheList.get(0);
                level.add(tmp.val);
                if(tmp.left!=null){
                    cacheList.add(tmp.left);
                }
                if(tmp.right!=null){
                    cacheList.add(tmp.right);
                }
                cacheList.remove(0);//移除第一个元素
            }
            cacheList.remove(0);//到了标志位后，移除标志位，进行下一层
            levels.add(level);//添加一层的结果
            cacheList.add(new TreeNode(Integer.MAX_VALUE));//添加标志位
        }
        return levels;
    }

}
