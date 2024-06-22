public class Solution {
   
private void Swap(ref int a, ref int b) {
    int temp = a;
    a = b;
    b = temp;
}
   private void solve(List<IList<int>> result, int n, int index, int[] nums) {
     if (index == n-1) {
        result.Add(new List<int>(nums));
        return;
    }
   
    for(int i=index; i<n; i++) {
   
        Swap(ref nums[index], ref nums[i]);
        solve(result, n, index + 1, nums); // Increment index
        Swap(ref nums[index], ref nums[i]);
    }
     
}

public IList<IList<int>> Permute(int[] nums) {
    int n = nums.Length;
    var result = new List<IList<int>>();
    solve(result, n, 0, nums);
    return result;
}
}