package 通用算法.正则表达式;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【12:25】.
 */
public class 测试匹配个数 {
    @Test
    public void test(){
        ArrayList<String> input=new ArrayList<>();
        input.add("Make yourself at home.");
        input.add("None of your business.");
        input.add("I will be more careful.");
        input.add("How about going to a movie?");
        input.add("Your life is your own affair.");
        input.add("You are Mine.");
        input.add("You and I can go to your house and see your parents.");
        Map<String,Integer> record=new HashMap<>();
        for(int i=0;i<input.size();i++){
            String s = input.get(i);
            record.put(s,s.split("(Y|y)our").length);
        }
        ArrayList<Map.Entry<String,Integer>> toSort=new ArrayList<>();
        toSort.addAll(record.entrySet());
        toSort.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i=0;i<toSort.size();i++){
            System.out.println(toSort.get(i).getKey());
        }
    }
}
