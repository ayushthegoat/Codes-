public class Solution {
     private void Solve(List<IList<int>> result, int[] nums, int index, List<int> temp, HashSet<string> set) {
        if (temp.Count >= 2) {
            string key = string.Join(",", temp);
            if (!set.Contains(key)) {
                result.Add(new List<int>(temp));
                set.Add(key);
            }
        }

        for (int i = index; i < nums.Length; i++) {
            if (temp.Count == 0 || nums[i] >= temp[temp.Count - 1]) {
                temp.Add(nums[i]);
                Solve(result, nums, i + 1, temp, set);
                temp.RemoveAt(temp.Count - 1);
            }
        }
    }

    public IList<IList<int>> FindSubsequences(int[] nums) {
        var result = new List<IList<int>>();
        var temp = new List<int>();
        var set = new HashSet<string>();

        Solve(result, nums, 0, temp, set);

        return result;
    }
}