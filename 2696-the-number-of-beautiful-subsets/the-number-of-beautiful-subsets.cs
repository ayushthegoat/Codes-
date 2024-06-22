public class Solution {
    private int result;
    private int n;
    private void Solve(int[] nums, int k, Dictionary<int,int> dick, int index) {
        if (index >= n)
        {
            result++;
            return;
        }

        // Not take case
        Solve(nums, k, dick, index + 1);

        // Take case
        int num = nums[index];

        // Ensure keys nums[index] + k and nums[index] - k exist in the dictionary
        if (!dick.ContainsKey(num + k))
        {
            dick[num + k] = 0;
        }
        if (!dick.ContainsKey(num - k))
        {
            dick[num - k] = 0;
        }

        // Take case
        if (!dick.ContainsKey(nums[index]) || dick[nums[index]] == 0)
        {
            dick[nums[index] + k]++;
            dick[nums[index] - k]++;
            Solve(nums, k, dick, index + 1);
            dick[nums[index] + k]--;
            dick[nums[index] - k]--;
        }
    }

    public int BeautifulSubsets(int[] nums, int k)
    {
        Dictionary<int, int> dick = new Dictionary<int, int>();

        foreach (var num in nums)
        {
            dick[num] = 0;
        }

        result = 0;
        n = nums.Length;

        Solve(nums, k, dick, 0);
        return result - 1;
    }
}