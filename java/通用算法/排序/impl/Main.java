package 通用算法.排序.impl;

import java.util.*;

/**
 * Created by【王耀冲】on 【2017/6/8】 at 【15:42】.
 */
public class Main {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<TreeNode> queue=new ArrayList<>();
        TreeNode flag=new TreeNode(Integer.MAX_VALUE);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        queue.add(root);
        queue.add(flag);
        boolean leftToRight=true;
        while(true){
            TreeNode treeNode = queue.get(0);
            if(treeNode.val==Integer.MAX_VALUE){
                leftToRight=!leftToRight;
                queue.remove(0);
                queue.add(flag);
            }else{
                ArrayList<Integer> arrayList = result.get(result.size() - 1);
                TreeNode treeNode1 = queue.get(0);
                arrayList.add(treeNode1.val);
                queue.remove(0);
                if(treeNode1.left!=null){
                    queue.add(treeNode1.left);
                }
                if(treeNode1.right!=null){
                    queue.add(treeNode1.right);
                }
            }
        }


        //code here
    }


    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);

        int N = jin.nextInt();

        int[] preOrder = new int[N];

        for( int i = 0; i < N; ++i)
            preOrder[i] = jin.nextInt();

        TreeNode root = buildTree(preOrder, new int[]{0});

        List<List<Integer>> res = new Main().zigzagLevelOrder(root);
        for(List<Integer> row: res){
            for( int i = 0; i < row.size(); ++i ){
                if( row.size()-1 == i )
                    System.out.println(row.get(i));
                else
                    System.out.print(row.get(i)+ " ");
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private static TreeNode buildTree(int[] preOrder, int[] index){

        int value = preOrder[index[0]++];

        if( 0 == value ) return null;

        TreeNode root = new TreeNode(value);

        root.left = buildTree(preOrder, index);

        root.right = buildTree(preOrder, index);

        return root;
    }

}
