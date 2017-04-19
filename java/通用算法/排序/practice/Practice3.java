package 通用算法.排序.practice;

import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/6】 at 【12:00】.
 */
public class Practice3 {
    public void swap(int[] input,int i,int j){
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
        UtilDisplay.display(input);
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
        UtilDisplay.display(input);
    }
    public void selectSort(int[] input){
        for(int i=0;i<input.length;i++){
            int minLoc=i;
            for(int j=i+1;j<input.length;j++){//这里j=i+1可以减少一次if语句
                if(input[minLoc]>input[j]){
                    minLoc=j;
                }
            }
            swap(input,minLoc,i);
        }
        UtilDisplay.display(input);
    }
    public void shellSort(int[]input){
        int k=input.length/2;
        while(k>0){
            for(int i=k;i<input.length;i++){
                int pivot=input[i];
                int j=i-k;
                while(j>=0&&pivot<input[j]){
                    input[j+k]=input[j];
                    j-=k;
                }
                input[j+k]=pivot;
            }
            k/=2;
        }
        UtilDisplay.display(input);
    }
    public void quickSort(int[]input,int start,int end){
        if(start<end){
            int mid=sortCore(input,start,end);
            quickSort(input,start,mid-1);
            quickSort(input,mid+1,end);
        }
    }
    public int sortCore(int[] input,int start,int end){
        int pivot=input[start];
        while(start<end){
            while(start<end&&input[end]>=pivot){
                end--;
            }
            input[start]=input[end];
            while(start<end&&input[start]<=pivot){
                start++;
            }
            input[end]=input[start];
        }
        input[start]=pivot;
        return start;
    }
    public void mergeSort(int[] input,int start,int end,int[] cache){
        if(start<end){
            int mid=start+((end-start)>>1);//这里要用括号>>运算符的优先级比加号低
            mergeSort(input,start,mid,cache);
            mergeSort(input,mid+1,end,cache);
            merge(input,start,mid,end,cache);
        }
    }
    public void merge(int[] input,int leftStart,int leftEnd,int rightEnd,int[] cache){
        int curLoc=leftStart;
        int rightStart=leftEnd+1;
        int copyStart=leftStart;
        int copyEnd=rightEnd;
        while(curLoc<=rightEnd){
            if(leftStart>leftEnd||(rightStart<=rightEnd&&input[rightStart]<input[leftStart])){
                cache[curLoc]=input[rightStart];
                rightStart++;
            }else{
                cache[curLoc]=input[leftStart];
                leftStart++;
            }
            curLoc++;
        }
        for(int i=copyStart;i<=copyEnd;i++){
            input[i]=cache[i];
        }
    }
    public void initMaxHeap(int[] input){
        for(int i=input.length/2;i>=0;i--){
            sinkMin(input,i,input.length-1);
        }
    }
    public void sinkMin(int[] input,int curLoc,int len){
        if(curLoc*2+1>len){//如果左孩子超过长度
            return ;
        }
        int maxChildLoc=curLoc*2+1;
        int rightChildLoc=curLoc*2+2;
        if(rightChildLoc<=len&&input[rightChildLoc]>input[maxChildLoc]){
            maxChildLoc=rightChildLoc;
        }
        if(input[curLoc]<input[maxChildLoc]){
            swap(input,curLoc,maxChildLoc);
            sinkMin(input,maxChildLoc,len);//递归调整
        }
    }
    public void heapSort(int[] input){
        int count=input.length-1;
        int orderCount=0;
        while(count>0){
            swap(input,0,count);//最大值放到最后
            sinkMin(input,0,count-1);//调整
            count--;
        }
        System.out.println(orderCount);
    }
    @Test
    public void testSort(){
        int [] input=new int[]{1,222,33,6,777,23,4,9,78};
//        bubbleSort(input);
//        insertSort(input);
//        selectSort(input);
//        shellSort(input);
//        quickSort(input,0,input.length-1);
//        mergeSort(input,0,input.length-1,new int[input.length]);
        initMaxHeap(input);
//        UtilDisplay.display(input);
        heapSort(input);
        UtilDisplay.display(input);
    }
}
