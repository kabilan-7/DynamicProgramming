package dynamicprogramming;
import java.util.*;
public class MinimumPathSum {
    //using memoization
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return findPathSum(grid,m - 1,n - 1,dp);
    }
    int findPathSum(int grid[][], int i, int j,int dp[][]){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(dp[i][j] != -1) return dp[i][j];
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i > 0){
            left = grid[i][j] + findPathSum(grid, i - 1, j,dp);
        }
        if(j > 0)
            right = grid[i][j] + findPathSum(grid, i, j - 1,dp);
        return dp[i][j] = Math.min(left,right);
    }
    //using tabulation
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i > 0) up+=dp[i - 1][j];
                    else up+=(int) Math.pow(10,9);
                    int left = grid[i][j];
                    if(j > 0) left+=dp[i][j - 1];
                    else left+=(int) Math.pow(10,9);
                    dp[i][j] = Math.min(up,left);
                }

            }
        }
        return dp[m - 1][n - 1];
    }

}
