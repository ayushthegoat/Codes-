public class Solution {
    private int n;
    private void Solve(int index,  Dictionary<char , string> dick, string digits, string temp, List<string> result) {
        if(index >= n) {
            result.Add(temp);
            return;
        }

        char ch = digits[index];
        string curr = dick[ch];
        for(int i = 0; i < curr.Length; i++) {
            temp += curr[i];
            Solve(index + 1, dick, digits, temp, result);
            temp = temp.Substring(0, temp.Length - 1);
        }

    }
    public IList<string> LetterCombinations(string digits) {

        this.n = digits.Length;
        var result = new List<string>();
        if(n == 0) {
            return result;
        }
        Dictionary<char , string> dick = new Dictionary<char, string>();

        dick['1'] = "";
        dick['2'] = "abc";
        dick['3'] = "def";
        dick['4'] = "ghi";
        dick['5'] = "jkl";
        dick['6'] = "mno";
        dick['7'] = "pqrs";
        dick['8'] = "tuv";
        dick['9'] = "wxyz";

        Solve(0, dick, digits, "", result);
        return result;

    }
}