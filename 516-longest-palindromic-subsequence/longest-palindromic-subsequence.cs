public class Solution {
    public int LongestPalindromeSubseq(string A) {
          string temp = A;
            temp = reverse(temp);
            int n = temp.Length;
            
            int[,] dp = new int[n+1, n+1];
            
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    
                    if(A[i-1] == temp[j-1]) {
                      dp[i, j] = 1 + dp[i-1, j-1];  
                    } else {
                      dp[i, j] = Math.Max(dp[i-1, j], dp[i, j-1]);
                    }
                    
                }
            }
            return dp[n, n];
       }
      private string reverse(string str) {
            char[] arr = str.ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }
}
     