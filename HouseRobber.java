package dynamicprogramming;

public class HouseRobber {
  static public int rob(int[] nums) {
        return func(nums.length - 1, nums);
    }
   static int func(int idx, int nums[]){
        if(idx < 0) return 0;
        if(nums[idx] == 0) return nums[idx];
        int noadj = nums[idx] + func(idx - 2, nums);
        int adj = func(idx - 1,nums);
        return Math.max(noadj,adj);
    }

    public static void main(String[] args) {
        int nums[] = {2,1,4,9};
        System.out.println(rob(nums));
    }
}
