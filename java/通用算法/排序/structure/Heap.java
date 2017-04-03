package 通用算法.排序.structure;

import Util.UtilArray;
import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/4/2】 at 【13:57】.
 */
public class Heap {
    public static void initMaxHeap(List<Integer> input){//初始化最小堆
        int nodePos=(input.size()-1)/2;
        while(nodePos>=0){
            sinkMin(input,nodePos);
            nodePos--;
        }
    }
    public static void sinkMin(List<Integer> input, int pos, int len){
        if(pos*2+1>=len){//不能是当pos*2+2>=input.size()的时候返回，因为可能只有一个孩子结点
            return ;
        }
        int minLoc=pos*2+1;
        if(pos*2+2<len){
            minLoc=input.get(pos*2+1)>input.get(pos*2+2)?pos*2+1:pos*2+2;
        }
        if(input.get(minLoc)>input.get(pos)){
            int tmp=input.get(pos);
            input.set(pos,input.get(minLoc));
            input.set(minLoc,tmp);
            sinkMin(input,minLoc,len);//递归操作使其满足最小堆的定义
        }
    }
    public static void sinkMin(List<Integer> input, int pos){
        if(pos*2+1>=input.size()){//不能是当pos*2+2>=input.size()的时候返回，因为可能只有一个孩子结点
            return ;
        }
        int minLoc=pos*2+1;
        if(pos*2+2<input.size()){
            minLoc=input.get(pos*2+1)>input.get(pos*2+2)?pos*2+1:pos*2+2;
        }
        if(input.get(minLoc)>input.get(pos)){
            int tmp=input.get(pos);
            input.set(pos,input.get(minLoc));
            input.set(minLoc,tmp);
            sinkMin(input,minLoc);//递归操作使其满足最小堆的定义
        }
    }
    public static void sinkMax(List<Integer> input, int pos, int len){
        if(pos*2+1>=len){//不能是当pos*2+2>=input.size()的时候返回，因为可能只有一个孩子结点
            return ;
        }
        int minLoc=pos*2+1;
        if(pos*2+2<len){
            minLoc=input.get(pos*2+1)<input.get(pos*2+2)?pos*2+1:pos*2+2;
        }
        if(input.get(minLoc)<input.get(pos)){
            int tmp=input.get(pos);
            input.set(pos,input.get(minLoc));
            input.set(minLoc,tmp);
            sinkMax( input, minLoc, len);//递归操作使其满足最小堆的定义
        }
    }
    public static void sinkMax(List<Integer> input, int pos){
        if(pos*2+1>=input.size()){//不能是当pos*2+2>=input.size()的时候返回，因为可能只有一个孩子结点
            return ;
        }
        int minLoc=pos*2+1;
        if(pos*2+2<input.size()){
            minLoc=input.get(pos*2+1)<input.get(pos*2+2)?pos*2+1:pos*2+2;
        }
        if(input.get(minLoc)<input.get(pos)){
            int tmp=input.get(pos);
            input.set(pos,input.get(minLoc));
            input.set(minLoc,tmp);
            sinkMax(input,minLoc);//递归操作使其满足最小堆的定义
        }
    }
    public static void initMinHeap(List<Integer> input){//初始化最小堆
        int nodePos=(input.size()-1)/2;
        while(nodePos>=0){
            sinkMax(input,nodePos);
            nodePos--;
        }
    }
    public static Object minHeapRemove(ArrayList list){
        UtilArray.swap(list,0,list.size()-1);
        Object remove = list.remove(list.size() - 1);
        sinkMax(list,0);
        return remove;
    }
    public static void minHeadInsert(ArrayList<Integer> list,Integer o){
        list.add(o);
        int index=list.size()-1;
        while(index>0){
            if(list.get(index/2)>o){
                list.set(index,list.get(index/2));
                index=index>>1;
            }else{
                break;
            }
        }
        list.set(index,o);
    }
    @Test
    public void testHeap(){
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,7,9,6,3,2,8));;
        initMinHeap(integers);
        minHeadInsert(integers,2);
//        Object o = minHeapRemove(integers);

//        initMaxHeap(integers);
        UtilDisplay.display(integers);
    }
}
