package LintCode.LintCodeSolution.面试需要的基础知识;

import org.junit.Test;

/**
 * Created by 【王耀冲】 on 【2017/2/7】 at 【15:12】.
 */
public class 单例 {
    static final 单例 s=new 单例();
    public static 单例 getInstance() {
        return s;
    }
    @Test
    public void test单例(){

    }
}
