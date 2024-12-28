public class Solution {
    public int FindTargetSumWays(int[] nums, int target) {
        return Helper(nums, target, 0, 0);
    }
    private int Helper(int[] arr, int target, int idx, int sum) {
        if(idx >= arr.Length) {
            return sum == target ? 1 : 0;
        }

        int subtract = Helper(arr, target, idx + 1, sum - arr[idx]);
        int add = Helper(arr, target, idx + 1, sum + arr[idx]);

        return subtract + add;
    }
}