package LintCode.LintCodeSolution.g两个面试案例;

import LintCode.LintCodeDefinition.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        postTravel(root, A, B);
        if (visited.indexOf(A)!=-1 && visited.indexOf(B)!=-1) {
            if(result==null){
                result = root;
            }
        }
        return result;
    }
    ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
    TreeNode result = null;
    Map<TreeNode,TreeNode> parent=new HashMap<TreeNode, TreeNode>();
    public void postTravel(TreeNode root, TreeNode A, TreeNode B) {

        if (root == null) {
            return;
        }
        postTravel(root.left, A, B);
        postTravel(root.right, A, B);
        if (visited.indexOf(A)!=-1 && visited.indexOf(B)!=-1) {
            if(result==null){
                result = root;
            }
        }
        visited.add(root);
    }

    public boolean isVisited(TreeNode n) {
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i).val == n.val) {
                return true;
            }
        }
        return false;
    }
}
