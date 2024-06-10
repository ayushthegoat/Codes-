//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:
    int Count(vector<vector<int> >& matrix) {
        // Code here
        int n = matrix.size();
        int m = matrix[0].size();
        int count = 0;
        
        const vector<pair<int,int>> directions = {
            {-1,-1},{-1,0},{-1,+1},{0,-1},{0,1},{+1,-1},{1,0},{1,1}
        };
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
               int temp = 0;
               if(matrix[i][j] == 1) {
                   for(const auto &dir : directions) {
                       int nrow = i + dir.first;
                       int ncol = j + dir.second;
                       
                       if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && matrix[nrow][ncol] == 0) {
                           temp++;
                       }
                   }
                   if(temp > 0 && temp % 2 == 0) {
                       count++;
                   }
               } 
               
            }
        }
        return count;
        
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>> matrix(n, vector<int>(m,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> matrix[i][j];
			}
		}
		Solution ob;
		int ans = ob.Count(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends