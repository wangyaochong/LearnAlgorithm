package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by finup on 2017/7/11.
 */
public class TestStreamMethod {
    @Test
    public void testListStream(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(-1);
        Stream<Integer> stream = arrayList.stream();
        stream.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).forEach(
                integer -> System.out.println(integer)
        );
    }
}
