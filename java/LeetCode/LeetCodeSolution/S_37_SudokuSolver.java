package LeetCode.LeetCodeSolution;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【17:20】.
 */
public class S_37_SudokuSolver {
    public void displaySudoku(char[][] inputChar){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(inputChar[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("--------------------");
    }
    @Test
    public void testSolve(){
//        String[] input=new String[]{"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
        String[] input=new String[]{".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."};
        char[][] inputChar=new char[9][9];
        for(int i=0;i<input.length;i++){
            char[] chars = input[i].toCharArray();
            for(int j=0;j<9;j++){
                inputChar[i][j]=chars[j];
            }
        }
       solveSudoku(inputChar);
        displaySudoku(inputChar);
    }
    char[] candidate=new char[]{'1','2','3','4','5','6','7','8','9'};
    public void solveSudoku(char[][] board) {
        getResult(board,0,0);
    }
    public  boolean  getResult(char[][] board,int xLox,int yLox){
        if(xLox==9){
            return true;
        }
        if(board[xLox][yLox]=='.'){
            for(int i=0;i<9;i++){
                if(isValidCurrentPos(board,xLox,yLox,candidate[i])){
                    board[xLox][yLox]=candidate[i];
                    if(getResult(board,xLox,yLox)){
                        return true;
                    }
                    board[xLox][yLox]='.';
                }
            }
        }else{//如果不是点
            while(xLox<9&& board[xLox][yLox]!='.'){
                yLox++;
                if(yLox==9){
                    xLox++;
                    yLox=0;
                }
            }
            return getResult(board,xLox,yLox);
        }
        return false;
    }
    public boolean isValidCurrentPos(char[][] board,int x,int y,int val) {
        //由于是逐步构建数组，因此不需要每次都检查一个完整的数独，只需要检查新插入的字符是否正确就可以了
        for(int i=0;i<9;i++){
            if(board[x][i]==val)return false;
            if(board[i][y]==val)return false;
        }
        int row=x-x%3;
        int col=y-y%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[row+i][col+j]==val)return false;
            }
        }
        return true;
    }
}
