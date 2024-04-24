class Solution {
public:
    int rob(vector<int>& arr) {
        int n = arr.size();
         vector<int> dp(n+1 , 0);
        //int[i = max stolen money till that house;
        
        dp[0]=0;
        dp[1]=arr[0];
        
        
        for(int i=2;i<=n;i++){
            int steal = arr[i-1] + dp[i-2];
            int skip = dp[i-1];
            
            dp[i] = max(steal,skip);
        }
        
        return dp[n];
    }
};