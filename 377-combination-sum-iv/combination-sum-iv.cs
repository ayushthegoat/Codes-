public class Solution {
    
    private int Solve(int[] nums, int target, int index, int[,] memo) {
        if(target == 0) {
            return 1;
        }

        if(target < 0) {
            return 0;
        }

        if(memo[target, index] != -1){
            return memo[target, index];
        }
        int n = 0;
        for(int i=index;i<nums.Length;i++) {
            target -= nums[i];
            n+=Solve(nums, target, 0, memo);
            target += nums[i];
        }
        memo[target, index] = n;
        return n;
    }
    public int CombinationSum4(int[] nums, int target) {
        int[,] memo = new int[target+1, nums.Length];
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.Length;j++){
                memo[i,j] = -1;
            }
        }
        return Solve(nums, target, 0, memo);
        
    }
}