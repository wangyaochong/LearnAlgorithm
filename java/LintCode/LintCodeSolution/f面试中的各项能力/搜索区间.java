package LintCode.LintCodeSolution.f面试中的各项能力;

public class 搜索区间 {
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int startLoc=0;
        int endLoc=0;
        while(startLoc<A.length&&A[startLoc]!=target)startLoc++;
        if(startLoc==A.length){
            return new int[]{-1,-1};
        }
        endLoc=startLoc;
        while(endLoc<A.length&& A[endLoc]==target)endLoc++;
        return new int[]{startLoc,endLoc-1};
    }
}
