class Solution {
    public long countSubarrays(int[] nums, int k) {
    long max = Long.MIN_VALUE;
    long count = 0;
    int i = 0;
    int j = 0;
    long res = 0;
    
    for (int x : nums) {
        max = Math.max(max, x);
    }

    while (i < nums.length) {
        if (max == nums[i]) {
            count++;
        }
        while (count >= k ) {
            res = res + (nums.length - i);
            if (nums[j] == max) {
                count--;
            }
            j++;
        }
       i++;
    }
        return res;
    }
}