package LintCode.LintCodeSolution;

import LintCode.LintCodeDefinition.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 【王耀冲】 on 【2017/2/9】 at 【15:04】.
 */
public class 前序遍历和中序遍历树构造二叉树 {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null|| preorder.length==0){
            return null;
        }
        // write 1your code here
        TreeNode head=new TreeNode(preorder[0]);
        int inLoc=findLoc(inorder,preorder[0]);
        getChild(preorder,inorder,0,inLoc-1,head,0);
        getChild(preorder,inorder,inLoc+1,inorder.length,head,1);
        return head;
    }
    //从一部分候选找到第一个从前序遍历出现的，返回的是前序遍历的数组的下标
    public int findFirstCandidateFromMidPartInPre(int[] preArr, int[] midArr,int start,int end){
        for(int i=0;i<preArr.length;i++){
            for(int j=start;j<=end;j++){
                if(j!=midArr.length&& preArr[i]==midArr[j]){
                    return i;
                }
            }
        }
        return -1;
    }
    public int findLoc(int [] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(target==arr[i])return i;
        }
        return -1;
    }
    //前序遍历的序列，中序遍历的序列，如果type是0，构造左孩子，type是1构造右孩子
    public void getChild(int[] preorder,int[] inorder,int start,int end, TreeNode head,int type){
        if (start == end && start != inorder.length) {
            TreeNode node = new TreeNode(inorder[start]);
            if (type == 0)
                head.left = node;
            else if (type == 1) {
                head.right = node;
            }
        } else {
            int preLoc = findFirstCandidateFromMidPartInPre(preorder, inorder, start, end);
            if (preLoc != -1) {
                TreeNode node = new TreeNode(preorder[preLoc]);
                if(type==0){
                    head.left = node;
                }else{
                    head.right=node;
                }
                getChild(preorder, inorder, start, findLoc(inorder, preorder[preLoc]) - 1, node, 0);
                getChild(preorder, inorder, findLoc(inorder, preorder[preLoc]) + 1, end, node, 1);
            }
        }
    }
    @Test
    public void testBuildTree(){
//        TreeNode treeNode = buildTree(new int[]{1,2,4,7,8,5,3,11,6,9,10}, new int[]{7,4,8,2,5,1,11,3,9,10,6});
//        TreeNode treeNode2 = buildTree(new int[]{1}, new int[]{1});
        TreeNode treeNode3 = buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }
}
