package LeetCode.LeetCodeSolution;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/5/20】 at 【20:46】.
 */
//将一个矩阵旋转90度，等于按照对角线折叠，然后按照中线折叠
public class S_48_RotateImage {
    @Test
    public void test(){
        int[][]matrix=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        diagonalFlip(matrix);
        middleFilp(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void swap(int[][]matrix,int i1,int j1,int i2,int j2){
        int tmp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=tmp;
    }
    public void rotate(int[][] matrix) {
        diagonalFlip(matrix);
        middleFilp(matrix);
    }
    public void diagonalFlip(int[][] matrix){
        int len=matrix.length;
        for(int i=0;i<len;i++){
            for(int j=0;j+i<len;j++){
                swap(matrix,i,j,len-1-j,len-1-i);
            }
        }
    }
    public void middleFilp(int[][] matrix){
        int len=matrix.length;
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len;j++){
                swap(matrix,i,j,len-1-i,j);
            }
        }
    }
}
