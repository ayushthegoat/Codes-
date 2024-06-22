public class Solution {
   private int[] t = new int[101];
    
    private int Solve(int[] nums, int i, int n)
    {
        if (i > n)
            return 0;
        
        if (t[i] != -1)
            return t[i];
        
        int take = nums[i] + Solve(nums, i + 2, n); // Steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = Solve(nums, i + 1, n); // Skips this house, now we can move to adjacent next house
        
        return t[i] = Math.Max(take, skip);
    }
    
    public int Rob(int[] nums)
    {
        int n = nums.Length;
        
        if (n == 1)
            return nums[0];
        
        if (n == 2)
            return Math.Max(nums[0], nums[1]);
        
        Array.Fill(t, -1);
        
        // Case-1 - Take first house (0th index)
        int take_0th_index_house = Solve(nums, 0, n - 2);
        
        Array.Fill(t, -1);
        
        // Case-2 - Take second house (1st index)
        int take_1st_index_house = Solve(nums, 1, n - 1);
        
        return Math.Max(take_0th_index_house, take_1st_index_house);
    }
}