public class Solution {
    private bool isValid(string s) {
    int l = 0;
    int r = s.Length - 1;

    while (l <= r) {
        if (s[l] != s[r]) {
            return false; // Change true to false
        }
        l++;
        r--;
    }
    return true; // Change false to true
}
    private void solve(List<IList<string>> result, string s, int index, List<string> temp) {
         if(index == s.Length) {
        result.Add(new List<string>(temp));
        return;
    }

    for(int i = index; i < s.Length; i++) {
        string substring = s.Substring(index, i - index + 1);
        if(isValid(substring)) {
            temp.Add(substring);
            solve(result, s, i + 1, temp);
            temp.RemoveAt(temp.Count - 1);
        }
    }
    }
    public IList<IList<string>> Partition(string s) {
        var result = new List<IList<string>>();
        var temo = new List<string>();

        solve(result, s, 0, temo);
        return result;
    }
}