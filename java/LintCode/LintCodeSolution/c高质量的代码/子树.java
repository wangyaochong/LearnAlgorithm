package LintCode.LintCodeSolution.c高质量的代码;

import LintCode.LintCodeDefinition.TreeNode;

/**
 * Created by 【王耀冲】 on 【2017/2/21】 at 【17:54】.
 */
public class 子树 {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        if (T1 == null){
            return false;
        }
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2)||isSame(T1,T2);//即使是两个节点相等的情况，如果不是子树，那么也得通过子树找是否是子树。
    }
    public boolean isSame(TreeNode T1,TreeNode T2){
        if(T1==T2&&T2==null){
            return true;
        }
        if(T1!=null&&T2!=null&& T1.val==T2.val){
            return isSame(T1.left,T2.left)&&isSame(T1.right,T2.right);
        }
        return false;
    }
}
