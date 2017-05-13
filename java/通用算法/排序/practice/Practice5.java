package 通用算法.排序.practice;

import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/5/13】 at 【11:56】.
 */
public class Practice5 {
    public void swap(int [] input,int i,int j){
        int tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
    }
    @Test
    public void test(){
        int[] input=new int[]{1,4,8,10,7,12,22,3};
//        bubbleSort(input);
//        insertSort(input);
//        selectSort(input);
//        shellSort(input);
//        quickSort(input,0,input.length-1);
        UtilDisplay.display(input);
    }
    public void mergeSort(int[] input,int i,int j){
        if(i<j){
            int mid=(i+j)/2;
            mergeSort(input,i,mid);
            mergeSort(input,mid+1,j);
            mergeSort(input,i,j);
        }
    }
    public void mergeCore(int[]input,int leftStart,int leftEnd,int rightEnd,int[] cache){
        int initStart=leftStart;
        int initEnd=rightEnd;
        int rightStart=leftEnd+1;
        int currentLoc=leftStart;
        while(currentLoc<=rightEnd){
            if(leftStart>leftEnd&&rightStart<=rightEnd|| input[leftStart]>input[rightStart]){
                cache[currentLoc]=input[rightStart];
                rightStart++;
            }else{
                cache[currentLoc]=input[leftStart];
                leftStart++;
            }
            currentLoc++;
        }
        for(int i=initStart;i<=initEnd;i++){
            input[i]=cache[i];
        }
    }
    public void quickSort(int[] input,int i,int j){
        if(i<j){
            int i1 = quickSortCore(input, i, j);
            quickSortCore(input,i,i1-1);
            quickSortCore(input,i1+1,j);
        }
    }
    public int quickSortCore(int[] input,int i,int j){
        int flag=input[i];
        while(i<j){
            while(i<j&&input[j]>=flag){
                j--;
            }
            input[i]=input[j];
            while(i<j&&input[i]<=flag){
                i++;
            }
            input[j]=input[i];
        }
        input[i]=flag;
        return i;
    }
    public void shellSort(int[]input){
        int step=input.length/2;
        while(step>0){
            for(int i=step;i<input.length;i+=step){
                int j=i-step;
                int flag=input[i];
                while(flag<input[j]){
                    input[j+step]=input[j];
                    j-=step;
                }
                input[j+step]=flag;
            }
            step/=2;
        }
    }
    public void selectSort(int[]input){
        for(int i=0;i<input.length;i++){
            int minLoc=i;
            for(int j=i+1;j<input.length;j++){
                if(input[minLoc]>input[j]){
                    minLoc=j;
                }
            }
            swap(input,minLoc,i);
        }
    }
    public void insertSort(int[] input){
        for(int i=1;i<input.length;i++){
            int flag=input[i];
            int j=i-1;
            while(flag<input[j]){
                input[j+1]=input[j];
                j--;
            }
            input[j+1]=flag;
        }
    }
    public void bubbleSort(int[] input){
        for(int i=1;i<input.length;i++){
            for(int j=i;j>0;j--){
                if(input[j]<input[j-1]){
                    swap(input,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
}
