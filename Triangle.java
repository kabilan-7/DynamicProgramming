package dynamicprogramming;
import java.util.*;
public class Triangle {
   //memoization
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return findMinSum(0,0,n,triangle,dp);
    }
    int findMinSum(int i, int j, int n,List<List<Integer>> grid,int dp[][]){
        if(i == n-1) return grid.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = grid.get(i).get(j) + findMinSum(i+1,j,n,grid,dp);
        int diagonal = grid.get(i).get(j) + findMinSum(i+1,j+1,n,grid,dp);
        return dp[i][j] = Math.min(down,diagonal);
    }

    //Tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int dia = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, dia);
            }
        }
        return dp[0][0];
    }
}
