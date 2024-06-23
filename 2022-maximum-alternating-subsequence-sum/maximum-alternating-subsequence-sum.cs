public class Solution {
    public long MaxAlternatingSum(int[] nums) {
        long[,] dp = new long[nums.Length + 1, 2];


        for(int i = 1; i<nums.Length + 1; i++){
            //for even length subsequence
            dp[i, 0] = Math.Max(dp[i - 1, 1] - nums[i - 1], dp[i - 1, 0]);

            //for odd length subsequence
            dp[i, 1] = Math.Max(dp[i - 1, 0] + nums[i - 1], dp[i - 1, 1]);
        }
        for(int i=0;i<dp.GetLength(0);i++) {
            for(int j=0;j<dp.GetLength(1);j++) {
                Console.WriteLine(dp[i, j] + " ");
            }
            Console.WriteLine();
        }

        return Math.Max(dp[nums.Length, 0], dp[nums.Length, 1]);
    }
}