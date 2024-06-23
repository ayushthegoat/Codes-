public class Solution {
    int s1;
    int s2;
    int[,] dp;
    private int Solve(string text1, string text2, int index1, int index2) {
        if(index1 >= s1 || index2 >= s2) {
            return 0;
        }

        if(dp[index1, index2] != -1) {
            return dp[index1, index2];
        }
        
        if(text1[index1] == text2[index2]) {
            return dp[index1, index2] = 1 + Solve(text1, text2, index1 + 1, index2 + 1);
        }

        int take_ith = Solve(text1, text2, index1, index2 + 1);
        int take_jth = Solve(text1, text2, index1 + 1, index2);

        return dp[index1, index2] = Math.Max(take_ith, take_jth);

    }

    public int LongestCommonSubsequence(string text1, string text2) {
         s1 = text1.Length;
         s2 = text2.Length;
         dp = new int[1001, 1001];
         for(int i=0;i<dp.GetLength(0); i++) {
            for(int j=0; j<dp.GetLength(1); j++) {
                dp[i, j] = -1;
            }
         }

         return Solve(text1, text2, 0, 0);
         
    }
}