package 通用算法.排序.practice;

import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/26】 at 【19:53】.
 */
public class Practice4 {
    public void swap(int[]input,int i,int j){
        int tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
    }
    public void bubbleSort(int[] input){
        for(int i=1;i<input.length;i++){
            for(int j=i;j>=1;j--){
                if(input[j]<input[j-1]){
                    swap(input,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
    public void selectSort(int[] input){
        for(int i=0;i<input.length;i++){
            int minLoc=i;
            for(int j=i+1;j<input.length;j++){
                if(input[minLoc]>input[j]){
                    minLoc=j;
                }
            }
            swap(input,i,minLoc);
        }
    }
    public void insertSort(int[] input){
        for(int i=1;i<input.length;i++){
            int pivot=input[i];
            int j=i-1;
            while(j>=0&&pivot<input[j]){
                input[j+1]=input[j];
                j--;
            }
            input[j+1]=pivot;
        }
    }
    public void quickSort(int[] input,int start,int end){
        if(start<end){
            int mid=partition(input,start,end);
            quickSort(input,start,mid-1);
            quickSort(input,mid+1,end);
        }
    }
    public int partition(int[] input,int start,int end){
        int pivot=input[start];
        while(start<end){
            while(start<end&&pivot<=input[end]){
                end--;
            }
            input[start]=input[end];
            while(start<end&&pivot>=input[start]){
                start++;
            }
            input[end]=input[start];
        }
        input[start]=pivot;
        return start;
    }
    public void mergeSort(int[] input,int start,int end,int[] cache){
        if(start<end){
            int mid=start+((end-start)>>1);
            mergeSort(input,start,mid,cache);
            mergeSort(input,mid+1,end,cache);
            mergeCore(input,start,mid,end,cache);
        }
    }
    public void mergeCore(int[] input,int leftStart,int leftEnd,int RightEnd,int[] cache){
        int rightStart=leftEnd+1;
        int initStart=leftStart;
        int initEnd=RightEnd;
        int currentLoc=leftStart;
        while(currentLoc<=RightEnd){
            if(leftStart>leftEnd||(rightStart<=RightEnd&&input[rightStart]<input[leftStart])){
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
    public void sinkMin(int[] input,int loc,int len){
        if(loc*2+1>len)return;
        int maxLoc=loc*2+1;//孩子的最大值等于左孩子的
        if(maxLoc+1<=len&&input[maxLoc]<input[maxLoc+1]){
            maxLoc=maxLoc+1;//孩子的最大值等于右孩子的
        }
        if(input[loc]<input[maxLoc]){//如果需要调整的结点小于孩子结点的最大值，那么就调整
            swap(input,loc,maxLoc);
            sinkMin(input,maxLoc,len);//递归下沉
        }
    }
    public void initMaxHeap(int[] input){
        for(int i=input.length/2;i>=0;i--){
            sinkMin(input,i,input.length-1);
            UtilDisplay.display(input);
        }
    }
    public void heapSort(int[] input){
        for(int i=input.length-1;i>=1;i--){
            swap(input,0,i);
            sinkMin(input,0,i-1);
        }
    }
    public void shellSort(int[] input){
        int k=input.length/2;
        while(k>0){
            for(int i=k;i<input.length;i+=k){
                int j=i-k;
                int pivot=input[i];
                while(j>=0&&pivot<input[j]){
                    input[j+k]=input[j];
                    j-=k;
                }
                input[j+k]=pivot;
            }
            k/=2;
        }
    }
    public static int currentSize=0;
    public void tryAdd(int[] input, int i){
        if(currentSize<input.length){
            int flag=currentSize;
            while(flag!=0&&i>input[(flag-1)/2]){
                input[flag]=input[(flag-1)/2];
                flag=(flag-1)/2;
            }
            input[flag]=i;
            currentSize++;
            return ;
        }
        if(i>input[0]){//为的是找出最小的10个元素，因此用大堆，如果比对顶还大，肯定不是最小的
            return ;
        }else{
            input[0]=i;
            sinkMin(input,0,input.length-1);
        }
    }

    @Test
    public void test(){
        int[] input=new int[8];
//        bubbleSort(input);
//        selectSort(input);
//        insertSort(input);
//        quickSort(input,0,input.length-1);
//        mergeSort(input,0,input.length-1,new int[input.length]);
//        initMaxHeap(input);
//        heapSort(input);
//        shellSort(input);
        int [] testInput=new int[] {1,2,32,3,4,2,3,6,66,6,22,3,2,1,1,22,3,3,6,6,7,2,233,3,5,5,56,8};
        for(int i=0;i<testInput.length;i++){
            tryAdd(input,testInput[i]);
        }
        UtilDisplay.display(input);
    }
}
