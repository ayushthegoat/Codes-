public class Solution {
    private int n;
    private int[,] memo;
    private int Solve(int[] nums, int index, int prev) {
        if(index >= n) {
            return 0;
        }

        int memoIndex = prev + 1;
        if (memo[index, memoIndex] != -1) {
            return memo[index, memoIndex];
        }

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]) {
            take = 1 + Solve(nums, index + 1, index);
        }
        int skip = Solve(nums, index+1, prev);
        
        memo[index, memoIndex] = Math.Max(take, skip);
        
        return memo[index, memoIndex];


    }

    public int LengthOfLIS(int[] nums) {
        n = nums.Length;
        memo = new int[n, n+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                memo[i, j] = -1;
            }
        }
        return Solve(nums, 0, -1);
    }
}