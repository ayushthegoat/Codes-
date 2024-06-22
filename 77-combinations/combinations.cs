public class Solution {
    public void Solve(int index, int k, List<int> temp, List<IList<int>> result) {
        if(k == 0) {
            result.Add(new List<int>(temp));
            return ;
        }

        if(index > n){
            return ;
        }

        temp.Add(index);
        Solve(index+1, k-1, temp, result);
        temp.RemoveAt(temp.Count - 1);
        Solve(index+1, k, temp, result);
    }
    private int n;
    public IList<IList<int>> Combine(int n, int k) {
        this.n = n;
        var result = new List<IList<int>>();
        var temp = new List<int>();

        Solve(1, k, temp, result);

        return result;
    }
}
 