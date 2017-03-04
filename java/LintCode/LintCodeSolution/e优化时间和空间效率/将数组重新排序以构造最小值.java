package LintCode.LintCodeSolution.e优化时间和空间效率;

import java.util.*;

public class 将数组重新排序以构造最小值 {
    public String minNumber(int[] nums) {
        List<Integer> numList=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            numList.add(nums[i]);
        }
        Collections.sort(numList, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String o1s = o1.toString();
                String o2s = o2.toString();

                //需要将两个字符串弄成一样长，因为
                //3和34比较，3排前面
                //3和32比较，32排前面
                while (o1s.length() < o2s.length()) {
                    o1s += o1s.charAt(o1s.length() - 1);
                }
                while (o2s.length() < o1s.length()) {
                    o2s += o2s.charAt(o2s.length() - 1);
                }
                return o1s.compareTo(o2s);
            }

        });
        String result="";
        for(int i=0;i<numList.size();i++){
            result+=numList.get(i).toString();
        }
        int zeroLoc=0;
        while(zeroLoc<result.length()&&result.charAt(zeroLoc)=='0'){
            zeroLoc++;
        }
        if(zeroLoc==result.length()){
            zeroLoc=zeroLoc-1;
        }
        return result.substring(zeroLoc,result.length());
    }
}
