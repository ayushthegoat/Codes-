//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    #define mod (int)(1e9 + 7)
    int nCr(int n, int r){
        if(n < r)return 0;
        // code here
          vector<vector<int>> t(n + 1, vector<int>(n + 1, 0));
          for(int i = 0; i <=n ; i++) {
              t[i][0] = 1;
          }
          
          for(int i = 1; i<=n ; i++) {
              for(int j=1;j<=i;j++) {
                  t[i][j] = (t[i-1][j-1] + 0LL + t[i-1][j]) % mod;
              }
          }
          
          return t[n][r];
          }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, r;
        cin>>n>>r;
        
        Solution ob;
        cout<<ob.nCr(n, r)<<endl;
    }
    return 0;
}
// } Driver Code Ends