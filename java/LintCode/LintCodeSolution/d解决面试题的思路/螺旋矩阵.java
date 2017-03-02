package LintCode.LintCodeSolution.d解决面试题的思路;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new ArrayList<Integer>();
        }
        //如果已经走过，则置为1
        int [][] flag=new int[matrix.length][];//这里按照列数分配空间
        for(int i=0;i<flag.length;i++){
            flag[i]=new int [matrix[0].length];//这里按照行数分配空间
        }
        int [][]direction=new int[][]{//定义四个行走方向
                {0,1},{1,0},{0,-1},{-1,0}
        };
        int directionLoc=0;
        List<Integer> result=new ArrayList<Integer>();
        int xLox=0;
        int yLox=0;
        while(flag[yLox][xLox]==0){
            flag[yLox][xLox]=1;
            result.add(matrix[yLox][xLox]);
            int tmpYLoc=yLox+direction[directionLoc][0];
            int tmpXLoc=xLox+direction[directionLoc][1];
            if( tmpXLoc>=0&&tmpYLoc>=0&& tmpYLoc<matrix.length&&tmpXLoc<matrix[0].length&&flag[tmpYLoc][tmpXLoc]==0   ){//如果没有出边界，且没有走过，则继续走
                yLox=tmpYLoc;
                xLox=tmpXLoc;
            }else{//如果出边界了，则转向
                directionLoc=(directionLoc+1)%4;
                tmpYLoc=yLox+direction[directionLoc][0];
                tmpXLoc=xLox+direction[directionLoc][1];
                if(!( tmpXLoc>=0&&tmpYLoc>=0&& tmpYLoc<matrix.length&&tmpXLoc<matrix[0].length&&flag[tmpYLoc][tmpXLoc]==0 )){//如果还是出边界，则跳出
                    break;
                }else{
                    yLox=tmpYLoc;
                    xLox=tmpXLoc;
                }
            }
        }
        return result;
    }
}
