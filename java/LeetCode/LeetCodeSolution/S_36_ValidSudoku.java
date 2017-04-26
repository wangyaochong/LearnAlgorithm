package LeetCode.LeetCodeSolution;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by【王耀冲】on 【2017/4/26】 at 【15:08】.
 */
public class S_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<Pair<Integer,Integer>> pos=new ArrayList<>();
        pos.add(new Pair<>(0,0));
        pos.add(new Pair<>(0,3));
        pos.add(new Pair<>(0,6));
        pos.add(new Pair<>(3,0));
        pos.add(new Pair<>(3,3));
        pos.add(new Pair<>(3,6));
        pos.add(new Pair<>(6,0));
        pos.add(new Pair<>(6,3));
        pos.add(new Pair<>(6,6));
        for(int i=0;i<9;i++){
            if(!(checkRow(board,i)&&checkCol(board,i)&&checkBox(board,pos.get(i).getKey(),pos.get(i).getValue()))){
                return false;
            }
        }
        return true;
    }
    public boolean checkRow(char [][] board,int row){
        ArrayList<Character> cache=new ArrayList<>();
        for(int i=0;i<9;i++){
            if(cache.contains(board[row][i])){
                return false;
            }
            if(board[row][i]!='.' ){
                cache.add(board[row][i]);
            }
        }
        return true;
    }
    public boolean checkCol(char [][] board, int col){
        ArrayList<Character> cache=new ArrayList<>();
        for(int i=0;i<9;i++){
            if(cache.contains(board[i][col])){
                return false;
            }
            if(board[i][col]!='.'){
                cache.add(board[i][col]);
            }
        }
        return true;
    }
    public boolean checkBox(char [][] board,int x,int y){
        ArrayList<Character> cache=new ArrayList<>();
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(cache.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    cache.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
