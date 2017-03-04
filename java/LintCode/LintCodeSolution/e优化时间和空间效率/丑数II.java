package LintCode.LintCodeSolution.e优化时间和空间效率;

import java.util.*;

public class 丑数II {
    public Long nthUglyNumber(int n) {
        // Write your code here
        int []multipleArr=new int[]{2,3,5};
        Set<Long> uglyNum=new HashSet<Long>();
        uglyNum.add((long) 1);//初始化1是第一个丑数
        while(uglyNum.size()<n*5){//这里乘以5是因为2*2等于4小于2*3，很多时候可能会中间夹杂一些小的数字。等有时间写一个更好的算法
            Set<Long> tmpArr=new HashSet<Long>();
            for (Long integer : uglyNum) {
                for (int i1 : multipleArr) {
                    if(i1*integer>0)
                        tmpArr.add(integer*i1);
                }
            }
            uglyNum.addAll(tmpArr);
        }
        List<Long> sortList=new ArrayList<Long>();
        sortList.addAll(uglyNum);
        Collections.sort(sortList);
        return sortList.get(n-1);
    }
}
