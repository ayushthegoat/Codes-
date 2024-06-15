public class Solution {

   private List<string> result = new List<string>();

    private bool IsValid(string str) {
        int count = 0;

        foreach (char ch in str) {
            if (ch == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    private void Solve(string curr, int n) {
        if (curr.Length == 2 * n) {
            if (IsValid(curr)) {
                result.Add(curr);
            }
            return;
        }

        curr += '(';
        Solve(curr, n);
        curr = curr.Substring(0, curr.Length - 1);

        curr += ')';
        Solve(curr, n);
        curr = curr.Substring(0, curr.Length - 1);
    }

    public IList<string> GenerateParenthesis(int n) {
        result.Clear();
        Solve("", n);
        return result;
    }
}