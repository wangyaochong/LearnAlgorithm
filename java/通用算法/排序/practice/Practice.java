package 通用算法.排序.practice;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【0:20】.
 */
public class Practice {
    public void bubbleSort(int[] input){
        for(int i=1;i<input.length;i++){
            for(int j=i-1;j>=0;j--){
                if(input[j+1]<input[j]){//如果后面的小于前面的，调换，则是从小到大排列
                    UtilArray.swap(input,j,j+1);
                }else{
                    break;//如果不用换位置，则说明排好了
                }
            }
        }
    }
    public void insertSort(int[] input){
        for(int i=1;i<input.length;i++){
            int j=i-1;
            int flag=input[i];//保存一下，因为后移会覆盖这个值
            for(;j>=0&&flag<input[j];j--){//依次比较前移
                input[j+1]=input[j];
            }
            input[j+1]=flag;
        }
    }
    public void shellSort(int[] input){
        int k=input.length/2;
        while(k>=1){
            for(int i=k;i<input.length;i++){
                int j=i-k;
                int flag=input[i];
                while(j>=0&&flag<input[j]){
                    input[j+k]=input[j];
                    j-=k;
                }
                input[j+k]=flag;
            }
            k/=2;
        }
    }
    public void quickSort(int[] input,int i,int j){
        if(i>=j)return;
        int div=sortCore(input,i,j);
        quickSort(input,div+1,j);
        quickSort(input,i,div-1);

    }
    public int sortCore(int[] input,int i, int j){
        int flag=input[i];
        while(i<j){
            while(i<j&&flag<=input[j]){//等号只要有一边包含就行，都包含也没问题
                j--;
            }
            input[i]=input[j];
            while(i<j&&flag>=input[i]){
                i++;
            }
            input[j]=input[i];
        }
        input[i]=flag;
        return i;
    }
    @Test
    public void testBubbleSort(){
        int [] arr=new int[]{1,33,3223,5,22,3,33,22,56,398};
//        bubbleSort(arr);
//        insertSort(arr);//需要记住插入排序和希尔排序都是flag的值和插入位置比较
//        shellSort(arr);
//        quickSort(arr,0,arr.length-1);
        UtilDisplay.display(arr);


    }
}
