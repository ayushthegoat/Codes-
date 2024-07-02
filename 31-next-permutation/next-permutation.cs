public class Solution {
    public void NextPermutation(int[] nums) {
        int n = nums.Length;
        int index = -1;

        for(int i = n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1) {
            Array.Reverse(nums);
            return;
        }

        for(int i=n-1; i>index; i--) {
            if(nums[i] > nums[index]) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                break;
            }
        }
        Array.Sort(nums, index+1, n-1-index);
    }
}