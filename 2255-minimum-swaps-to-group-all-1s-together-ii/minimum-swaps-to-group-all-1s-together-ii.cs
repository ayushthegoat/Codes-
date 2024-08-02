public class Solution {
    public int MinSwaps(int[] nums) {
        int n = nums.Length;

        int ones = nums.Count(val => val == 1);

        int i = 0;
        int j = 0;
        int countOnes = 0;
        int maxOnes = 0;
        while(i < 2 * n) {
            if(nums[i % n] == 1){
                countOnes++;
            }
            if(i - j + 1 > ones) {
                countOnes -= nums[j % n];
                j++;
            }

            maxOnes = Math.Max(countOnes, maxOnes);
            i++;
        }
        return ones - maxOnes;
    }
}