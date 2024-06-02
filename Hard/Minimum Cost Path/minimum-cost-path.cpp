//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    int minimumCostPath(vector<vector<int>>& grid) 
    {
        // Code here
        vector<vector<int>>dist(grid.size(),vector<int>(grid[0].size(),1e9));
        set<pair<int,pair<int,int>>>st;
        
        const vector<pair<int,int>> directions = {
            {1,0},{0,1},{-1,0},{0,-1}
        };
        
       priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> q;
        q.push({grid[0][0],{0,0}});
  
        
        while(!q.empty()){
            auto it = q.top();
            q.pop();
            int currDist = it.first;
            int row = it.second.first;
            int col = it.second.second;
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
    
                
                if(nrow>=0 && nrow<grid.size() && ncol>=0 && ncol<grid[0].size() ){
                    if(currDist + grid[nrow][ncol] < dist[nrow][ncol]){
                        dist[nrow][ncol] = currDist + grid[nrow][ncol];
                        q.push({dist[nrow][ncol], {nrow,ncol}});
                    }
                }
            }
        }
        if(dist[grid.size()-1][grid[0].size()-1] == 1e9){
            return -1;
        }
        return dist[grid.size()-1][grid[0].size()-1];
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends