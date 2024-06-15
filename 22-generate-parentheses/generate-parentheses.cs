public class Solution {

   private List<string> result = new List<string>();

    private void Solve(string curr, int n, int open, int close) {
        if (curr.Length == 2 * n) {
            result.Add(curr);
            return;
        }

        if(open < n) {
        curr += '(';
        Solve(curr, n, open+1, close);
        curr = curr.Substring(0, curr.Length - 1);
        }

        if(close < open) {
        curr += ')';
        Solve(curr, n, open, close+1);
        curr = curr.Substring(0, curr.Length - 1);
        }

    }

    public IList<string> GenerateParenthesis(int n) {
        result.Clear();
        int open = 0;
        int close = 0;
        Solve("", n, open, close);
        return result;
    }
}