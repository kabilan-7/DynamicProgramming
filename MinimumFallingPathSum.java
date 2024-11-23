package dynamicprogramming;
import java.util.*;
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        int minPathSum = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            int ans = func(m - 1, j,n,matrix,dp);
            minPathSum = Math.min(minPathSum,ans);
        }
        return minPathSum;
    }
    int func(int i,int j,int n,int grid[][], int dp[][]){
        if(j < 0 || j >= n) return (int)Math.pow(10,9);
        if(i == 0) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + func(i - 1,j, n , grid,dp);
        int leftdia = grid[i][j] + func(i - 1, j - 1, n , grid,dp);
        int rightdia = grid[i][j] + func(i - 1, j + 1, n ,  grid,dp);
        return dp[i][j] = Math.min(Math.min(up,leftdia),rightdia);
    }


    //Tabulation
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1 ;i < n; i++){
            for(int j = 0; j < n; j++){
                int up = matrix[i][j] + dp[i - 1][j];
                int leftdia = matrix[i][j];
                if(j - 1 >= 0) leftdia += dp[i - 1][j - 1];
                else leftdia += (int)Math.pow(10,9);
                int rightdia = matrix[i][j];
                if(j + 1 < n) rightdia += dp[i - 1][j + 1];
                else rightdia += (int)Math.pow(10,9);
                dp[i][j] = Math.min(Math.min(up,leftdia),rightdia);
            }
        }
        int minPathSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minPathSum = Math.min(minPathSum,dp[n - 1][i]);
        }
        return minPathSum;
    }

}
