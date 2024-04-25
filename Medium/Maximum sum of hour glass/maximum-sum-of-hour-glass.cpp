//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int findMaxSum(int n, int m, vector<vector<int>> mat) {
        // code here
        int row = mat.size();
        int col = mat[0].size();
        
        int mx = -1;
        for(int i=1;i+1<row;i++){
            for(int j=1;j+1<col;j++){
                int sum = 0;
                sum+= mat[i][j];
                sum+= mat[i-1][j];
                sum+= mat[i-1][j-1];
                sum+= mat[i-1][j+1];
                sum+= mat[i+1][j];
                sum+= mat[i+1][j-1];
                sum+= mat[i+1][j+1];
                
                mx = max(mx,sum);
            }
        }
        return mx;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M, i, j;
        cin >> N >> M;
        vector<vector<int>> Mat(N, vector<int>(M));
        for (i = 0; i < N; i++)
            for (j = 0; j < M; j++) cin >> Mat[i][j];
        Solution ob;
        cout << ob.findMaxSum(N, M, Mat) << "\n";
    }
}
// } Driver Code Ends