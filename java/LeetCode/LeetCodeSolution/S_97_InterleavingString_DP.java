package LeetCode.LeetCodeSolution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class S_97_InterleavingString_DP {
    @Test
    public void test() {
        System.out.println(isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) return s3 == null;
        if (s1 == null) return s2.equals(s3);
        if (s2 == null) return s1.equals(s3);
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))
                        ||dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)));
            }
        }
        display(dp);
        return dp[m][n];
    }
    public void display(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]){
                    System.out.print("1  ,");
                }else {
                    System.out.print("0  ,");
                }
//                System.out.print(dp[i][j]+"     ,");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
