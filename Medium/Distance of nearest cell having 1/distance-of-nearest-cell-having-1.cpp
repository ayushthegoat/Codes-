//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution 
{
    public:
    //Function to find distance of nearest 1 in the grid for each cell.
	vector<vector<int>>nearest(vector<vector<int>>grid)
	{
	    // Code here
	    int n = grid.size();
	    int m = grid[0].size();
	  
	     vector<vector<int>>ans(n,vector<int>(m));
	     vector<vector<int>>vis(n,vector<int>(m));
	     queue<pair <pair<int,int>, int> >q;
	           //first.1st,first.2nd second
	           
	           for(int i=0;i<n;i++){
	               for(int j=0;j<m;j++){
	                   if(grid[i][j]==1){
	                       q.push({{i,j},0});
	                       vis[i][j] = 1;
	                   }
	               }
	           }
	           
	            static const vector<pair<int,int>> directions = {
	           {0,1},{1,0},{-1,0},{0,-1}
	       };
	      
	       
	       while(!q.empty()){
	            int row = q.front().first.first;
	            int col = q.front().first.second;
	            int steps = q.front().second;
	            q.pop();
	            ans[row][col] = steps;
	            
	       
	            
	            for(auto dir : directions){
	                int nrow = row + dir.first;
	                int ncol = col + dir.second;
	                
	                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
	                    q.push({{nrow,ncol},steps+1});
	                    vis[nrow][ncol] = 1;
	                }
	            }
	       }
	       return ans;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>grid(n, vector<int>(m, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		vector<vector<int>> ans = obj.nearest(grid);
		for(auto i: ans){
			for(auto j: i){
				cout << j << " ";
			}
			cout << "\n";
		}
	}
	return 0;
}
// } Driver Code Ends