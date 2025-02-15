public class Solution {
    public bool IsArraySpecial(int[] nums) {
        for(int i = 0; i < nums.Length - 1; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            if(parityChecker(first, second)) return false ;
        }

        return true;
    }
    private bool parityChecker(int num1, int num2) {
       return (num1 & 1) == (num2 & 1);      
    }
}