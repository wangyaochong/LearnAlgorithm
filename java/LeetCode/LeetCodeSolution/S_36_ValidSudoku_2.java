package LeetCode.LeetCodeSolution;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by【王耀冲】on 【2017/4/26】 at 【15:08】.
 */
public class S_36_ValidSudoku_2 {
    public boolean isValidSudoku(char[][] board) {
        int [][] usedCol=new int [9][10];
        int [][] usedRow=new int[9][10];
        int [][] usedBox=new int[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if (board[i][j]!='.'&&(usedRow[i][board[i][j] - '0']!=0||usedCol[j][board[i][j]-'0']!=0||usedBox[(i/3*3)+(j/3)][board[i][j]-'0']!=0)){
                    return false;
                }
                if(board[i][j]!='.'){
                    usedRow[i][board[i][j] - '0']=1;
                    usedCol[j][board[i][j]-'0']=1;
                    usedBox[(i/3*3)+(j/3)][board[i][j]-'0']=1;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        String[] input=new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char[][] inputChar=new char[9][9];
        for(int i=0;i<input.length;i++){
            char[] chars = input[i].toCharArray();
            for(int j=0;j<9;j++){
                inputChar[i][j]=chars[j];
            }
        }
        System.out.println(isValidSudoku(inputChar));
    }
}
