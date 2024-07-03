public class Solution {
    public string ShortestCommonSupersequence(string str1, string str2) {
        
        int n = str1.Length;
        int m = str2.Length;

        int [,] dp = new int[n + 1, m + 1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {

                if(str1[i-1] == str2[j-1]) {
                    dp[i, j] = 1 + dp[i - 1, j - 1];

                } else {
                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                }
            }
        }

        int a = n;
        int b = m;
        StringBuilder sb = new StringBuilder();
        string ans = "";
        while(a > 0 && b > 0) {
            if(str1[a - 1] == str2[b - 1]) {
                sb.Append(str1[a - 1]);
                a--;
                b--;
            } else if (dp[a, b - 1] > dp[a - 1, b]){
                sb.Append(str2[b - 1]);
                b--;
            } else {
                sb.Append(str1[a - 1]);
                a--;
            }
        }

        while( a > 0) {
            sb.Append(str1[a - 1]);
            a--;
        }
        while( b > 0) {
            sb.Append(str2[b - 1]);
            b--;
        }
        
        char[] arr = sb.ToString().ToCharArray();
        Array.Reverse(arr);
        return new String(arr);
    }
}