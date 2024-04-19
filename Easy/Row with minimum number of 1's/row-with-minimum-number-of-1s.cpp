//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
   int counter(vector<int>&s, int size){
        int ctr=0;
        
        
        for(int i=0;i<size;i++){
            if(s[i]==1){
                ctr++;
            }
        }
        return ctr;
    }
    int minRow(int n, int m, vector<vector<int>> a) {
        // code here
        int mx = INT_MAX;
        int index = 0;
        int res = 0;
        
        for(auto s : a){
            index++;
            int curr = counter(s , s.size());
            
            if(curr<mx){
                mx = curr;
                res = index;
                
            }
            
        }
        return res;
    }
     
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M;
        cin >> N >> M;
        vector<vector<int>> A(N, vector<int>(M));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cin >> A[i][j];
            }
        }
        Solution ob;
        cout << ob.minRow(N, M, A) << "\n";
    }
}
// } Driver Code Ends