package a面试常见;

import Util.UtilDisplay;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【9:02】.
 */
public class 找出数组中的重复值 {
    public List<Integer> findDuplicates(int[] a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int [] cache=new int[200000000];
        for(int i=0;i<a.length;i++){
            if(cache[a[i]]==1){
                arrayList.add(a[i]);
            }
            cache[a[i]]++;
        }
        return arrayList;
    }

        public List<Integer> findDuplicatesWrong(int[] a) {
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<a.length; ++i){
            int index=Math.abs(a[i])-1;
            if(a[index]<0)
                list.add(Math.abs(index+1));
            a[index]=-a[index];
        }
        return list;
    }
    @Test
    public void test(){
//        List<Integer> duplicates = findDuplicatesWrong(new int[]{100,1, 1, 2, 2, 3, 4, 4, 5, 6,100});
        List<Integer> duplicates = findDuplicates(new int[]{100,1, 1,1,1, 2, 2, 3, 4, 4, 5, 6,100});
        UtilDisplay.display(duplicates);
    }
}
