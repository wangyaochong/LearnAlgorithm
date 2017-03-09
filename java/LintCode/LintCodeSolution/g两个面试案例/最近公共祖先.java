package LintCode.LintCodeSolution.g两个面试案例;

import LintCode.LintCodeDefinition.TreeNode;

import java.util.ArrayList;

public class 最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        int loc=0;
        isFind=false;
        midTravel(root,A,aParent);
        isFind=false;
        midTravel(root,B,bParent);
        while(loc<aParent.size()&&loc<bParent.size()&& aParent.get(loc)==bParent.get(loc)){//一路往下遍历，找到最后一个公共祖先
            loc++;
        }
        if(loc==0){
            return null;
        }
        return aParent.get(loc-1);
    }
    ArrayList<TreeNode> aParent=new ArrayList<TreeNode>();//记录a的祖先
    ArrayList<TreeNode> bParent=new ArrayList<TreeNode>();//记录b的祖先
    boolean isFind =false;
    public void midTravel(TreeNode root,TreeNode a, ArrayList<TreeNode> parent){
        if(root==null){
            return;
        }
        if(isFind ==false){
            parent.add(root);
        }
        if(root==a){
            isFind =true;
        }
        midTravel(root.left,a,parent);
        midTravel(root.right,a,parent);
        if(parent!=null&& isFind ==false){
            parent.remove(parent.size()-1);
        }
    }
}
