package LintCode.LintCodeSolution.b面试需要的基础知识;

/**
 * Created by 【王耀冲】 on 【2017/2/14】 at 【11:20】.
 */

import org.junit.Test;

/**
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 */
public class 搜索二维矩阵II {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int count = 0;
        int jLoc = matrix[0].length - 1;//从第一行的最左边开始查找
        while(jLoc>=0&& matrix[0][jLoc]>target){
            jLoc--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = jLoc; j >= 0; j--) {
                if(matrix[i][j]==target){
                    count++;
                    jLoc--;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void testSearchMatrix() {
        int[][] m = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6}
        };
        int [][] m2={
                {5}
        };
        System.out.println(searchMatrix(m2,2));
    }
}
