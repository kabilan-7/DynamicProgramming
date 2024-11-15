package dynamicprogramming;

public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int heights[] = {10,20,30,20};
//        System.out.println(func(heights,n - 1, 3));
        System.out.println(memoizationFunc(n,heights,3));
    }
    static int memoizationFunc(int n,int heights[], int k){
        int dp[] = new int[n];
        for(int i = 1; i < n; i++){
            int minStep = Integer.MAX_VALUE;
            for(int j = 1; j < n; j++){
                if(i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minStep = Math.min(minStep, jump);
                }
            }
            dp[i] = minStep;
        }
        return dp[n - 1];
    }
    static int func(int heights[], int idx, int k){
        if(idx == 0){
            return 0;
        }
        int minStep = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (idx - j >= 0) {
                int step = func(heights, idx - j, k) + Math.abs(heights[idx] - heights[idx - j]);
                minStep = Math.min(minStep, step);
            }
        }
        return minStep;
    }
}
