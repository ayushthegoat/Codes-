public class Solution {
    

   public void solve(List<IList<int>> result, Dictionary<int, int> map, int[] nums, List<int> temp) {
        if (temp.Count == nums.Length) {
            result.Add(new List<int>(temp)); // Add a copy of temp
            return;
        }

        foreach (var it in map) {
            if (it.Value == 0) {
                continue;
            }
            temp.Add(it.Key); // Add the current key to the temp list
            map[it.Key]--; // Decrement the value in the map
            solve(result, map, nums, temp); // Recur

            temp.RemoveAt(temp.Count - 1); // Backtrack by removing the last element
            map[it.Key]++; // Increment the value in the map to backtrack
        }
    }

    public IList<IList<int>> PermuteUnique(int[] nums) {
        var result = new List<IList<int>>();
        Dictionary<int, int> map = new Dictionary<int, int>();
        List<int> temp = new List<int>();

        foreach (var num in nums) {
            map[num] = map.GetValueOrDefault(num, 0) + 1;
        }

        solve(result, map, nums, temp);
        return result;
    }
}