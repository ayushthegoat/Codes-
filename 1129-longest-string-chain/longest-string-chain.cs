public class Solution {

    private bool check(string s1, string s2) {
        // Console.WriteLine(s1);
        // Console.WriteLine(s2);
          if (s2.Length - s1.Length != 1) {
        return false;
    }

    int i = 0, j = 0;
    while (i < s1.Length && j < s2.Length) {
        if (s1[i] == s2[j]) {
            i++;
        }
        j++;
    }

    return i == s1.Length;
    }

    public int LongestStrChain(string[] words) {
        int n = words.Length;
        Array.Sort(words, (a,b)=> a.Length.CompareTo(b.Length));

        int[] dp = new int[n];

        int max = 1;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(check(words[j], words[i]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                  
                }
            }
               max = Math.Max(max, dp[i]);
        }
        return max;
    }
}