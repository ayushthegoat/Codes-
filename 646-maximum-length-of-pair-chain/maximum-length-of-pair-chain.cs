public class Solution {
    public int FindLongestChain(int[][] nums) {
        int n = nums.Length;
        Array.Sort(nums, (a,b)=>a[1].CompareTo(b[1]));

        int[] dp = new int[n];
         for(int i=0;i<n;i++){
              dp[i] = 1;
           }

        int max = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j][1] < nums[i][0]) {
                    dp[i] = Math.Max(dp[i], dp[j] + 1);
                    max = Math.Max(dp[i], max);
                }
            }
        }
        return max;
    }
}