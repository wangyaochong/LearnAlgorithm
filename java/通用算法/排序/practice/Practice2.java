package 通用算法.排序.practice;

import Util.UtilDisplay;
import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/4/5】 at 【20:01】.
 */
public class Practice2{
    public void bubbleSort(int[] input){
        for(int i=1;i<input.length;i++){
            for(int j=i;j>=1;j--){
                if(input[j]<input[j-1]){
                    int tmp=input[j];
                    input[j]=input[j-1];
                    input[j-1]=tmp;
                }else{
                    break;
                }
            }
        }
        UtilDisplay.display(input);
    }
    public void insertSort(int[] input){
        for(int i=1;i<input.length;i++){
            int j=i;
            int pivot=input[j];
            while(j>=1&& pivot<=input[j]){
                input[j]=input[j-1];
                j--;
            }
            input[j+1]=pivot;
        }
        UtilDisplay.display(input);
    }
    public void selectSort(int[] input){
        for(int i=0;i<input.length;i++){
            int minLoc=i;
            for(int j=i;j<input.length;j++){
                if(input[minLoc]>input[j]){
                    minLoc=j;
                }
            }
            int tmp=input[minLoc];
            input[minLoc]=input[i];
            input[i]=tmp;
        }
        UtilDisplay.display(input);
    }
    public void shellSort(int[] input){
        int k=input.length/2;
        while(k>0){
            for(int i=k;i<input.length;i++){//完成一次距离为k的插入排序
                int pivot=input[i];
                int j=i;
                while(j>=k&& pivot<=input[j]){
                    input[j]=input[j-k];
                    j=j-k;
                }
                input[j+k]=pivot;
            }
            k=k/2;
        }
        UtilDisplay.display(input);
    }
    public void shellSortNoEqual(int[]input){
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
    public void quickSort(int[] input,int start,int end){
        if(start<end){
            int div=sortCore(input,start,end);
            quickSort(input,start,div-1);
            quickSort(input,div+1,end);
        }
    }
    public int sortCore(int[] input,int start,int end){
        int pivot=input[start];
        while(start<end){
            while(start<end&&input[end]>=pivot){//找到小的放到前面
                end--;
            }
            input[start]=input[end];
            while(start<end&&input[start]<=pivot){//找到大的放到后面
                start++;
            }
            input[end]=input[start];
        }
        input[start]=pivot;
        return start;
    }
    public void mergeSort(int[] input,int start,int end,int[] cache){
        if(start<end){
            int div=(start+end)/2;
            mergeSort(input,start,div,cache);//都是使用闭区间，这样可以包含所有情况
            mergeSort(input,div+1,end,cache);
            merge(input,start,div,end,cache);
        }
    }
    public void merge(int[] input,int leftStart,int leftEnd,int rightEnd,int[] cache){
        int rightStart=leftEnd+1;
        int currentLoc=leftStart;
        int initStart=currentLoc;
        int initEnd=rightEnd;
        while(currentLoc<=rightEnd){
            if(leftStart>leftEnd||(rightStart<=rightEnd&& input[rightStart]<input[leftStart])){//当左边用完了或者右边比左边大
                cache[currentLoc]=input[rightStart];//这边需要使用缓存，因为赋值会改变自身
                rightStart++;
            }else{
                cache[currentLoc]=input[leftStart];
                leftStart++;
            }
            currentLoc++;
        }
        for(int i=initStart;i<=initEnd;i++){//更新排序后的值
            input[i]=cache[i];
        }
    }
    public void heapInit(int [] input){//堆排序，从小到大排需要大堆，从大到小排需要小堆
        for(int i=input.length/2;i>=0;i--){
            sinkMin(input,i,input.length-1);
        }
    }
    public void sinkMin(int[] input, int loc,int len){//将当前结点和子结点比较，如果需要换位，则递归换位
        if(loc*2+1>len){//如果是叶子，直接返回
            return ;
        }
        int childMaxLoc=loc*2+1;
        if(loc*2+2<=len&&input[loc*2+2]>input[childMaxLoc]){//如果有右孩子
            childMaxLoc=loc*2+2;
        }
        if(input[loc]<input[childMaxLoc]){//只有当父亲小于孩子，才交换
            int tmp=input[childMaxLoc];//交换父子的位置
            input[childMaxLoc]=input[loc];
            input[loc]=tmp;
            sinkMin(input,childMaxLoc,len);//递归调整
        }
    }
    public void swap(int[]input,int i,int j){
        int tmp=input[i];
        input[i]=input[j];
        input[j]=tmp;
    }
    public void heapSort(int []input){
        int loc=input.length-1;
        while(loc>0){//最后一个位置不用交换，因为最后一个位置一定是排好序的。
            swap(input,0,loc);//把最大放到最后
            System.out.println("交换");
            UtilDisplay.display(input);
            System.out.println("下沉");
            sinkMin(input,0,loc-1);
            UtilDisplay.display(input);
            loc--;
        }
    }
    @Test
    public void testSort(){
//        bubbleSort(new int[] {1,2,3,83,29,223,11,112,33});
//        insertSort(new int[] {1,2,3,83,29,223,11,112,33});
//        selectSort(new int[] {1,2,3,83,29,223,11,112,33});
//        shellSort(new int[] {1,2,3,83,29,223,11,112,33});
//        shellSortNoEqual(new int[] {1,2,3,83,29,223,11,112,33});
        int[] ints = {1, 2, 3, 83, 29, 223, 11, 112, 33};
        heapInit(ints);
        UtilDisplay.display(ints);
        System.out.println("初始化结束");
        heapSort(ints);
        UtilDisplay.display(ints);
//        quickSort(ints,0,ints.length-1);
//        mergeSort(ints,0,ints.length-1,new int[ints.length]);
//        UtilDisplay.display(ints);
    }

    /**
     *排序备忘：
     * 1、插入排序：核心代码input[j+1]=input[j],input[j+1]=pivot；这样可以不用等于号
     * 2、希尔排序：核心代码input[j+k]=input[j],input[j+k]=pivot;
     * 3、归并排序：需要有一个缓存，因为在排序过程中，input本身会变，所以需要先排缓存，然后更新input的值
     * 4、堆排序：最后一个元素不用调整
     */
}
