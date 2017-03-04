package LintCode.LintCodeSolution.e优化时间和空间效率;

public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        // Write your code here
        if(n==0){
            return new int [0][0];
        }
        int [][] flat=new int [n][];//没走过标志位则为0
        int [][] matrix=new int[n][];//返回的螺旋矩阵
        for(int i=0;i<flat.length;i++){
            flat[i]=new int[n];
            matrix[i]=new int[n];
        }

        int[][] direction=new int[][]{
                {0,1},{1,0},{0,-1},{-1,0}
        };

        int xLoc=0;
        int yLoc=0;
        int currentNum=1;
        int directionLoc=0;
        while(true){
            flat[yLoc][xLoc]=1;//记录标志位
            matrix[yLoc][xLoc]=currentNum;
            currentNum++;

            int tmpYLoc=yLoc+direction[directionLoc][0];
            int tmpXLoc=xLoc+direction[directionLoc][1];

            if(tmpXLoc<n&&tmpYLoc<n&&tmpXLoc>=0&&tmpYLoc>=0&&flat[tmpYLoc][tmpXLoc]==0){//只有当没出范围且没走过，则同一方向行走
                xLoc=tmpXLoc;
                yLoc=tmpYLoc;
            }else{//否则更换方向
                directionLoc=(directionLoc+1)%4;
                tmpYLoc=yLoc+direction[directionLoc][0];
                tmpXLoc=xLoc+direction[directionLoc][1];
                if(!(tmpXLoc<n&&tmpYLoc<n&&tmpXLoc>=0&&tmpYLoc>=0&&flat[tmpYLoc][tmpXLoc]==0)){//如果还不满足条件，则返回
                    return matrix;
                }else{
                    xLoc=tmpXLoc;
                    yLoc=tmpYLoc;
                }
            }

        }
    }
}
