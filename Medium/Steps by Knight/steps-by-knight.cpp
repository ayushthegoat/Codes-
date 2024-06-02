//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution 
{
    public:
    //Function to find out minimum steps Knight needs to reach target position.
	int minStepToReachTarget(vector<int>&KnightPos,vector<int>&TargetPos,int n)
	{
	    // Code here
	    // All possible moves of a knight
        vector<pair<int, int>> directions = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        // Queue for BFS
        queue<pair<int,pair<int, int>>> q;
        // Visited matrix to keep track of visited positions
        vector<vector<bool>> vis(n + 1, vector<bool>(n + 1, false));
        int N = KnightPos[0];
        int M = KnightPos[1];
        
        int X = TargetPos[0];
        int Y = TargetPos[1];
        vis[N][M] = true;
        q.push({0,{N,M}});
        
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int currDist = it.first;
            int row = it.second.first;
            int col = it.second.second;
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
                if(nrow == X && ncol == Y)return currDist+1;
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    q.push({currDist+1,{nrow,ncol}});
                    vis[nrow][ncol] = true;
                }
            }
        }
        return 0;
        
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		vector<int>KnightPos(2);
		vector<int>TargetPos(2);
		int N;
		cin >> N;
		cin >> KnightPos[0] >> KnightPos[1];
		cin >> TargetPos[0] >> TargetPos[1];
		Solution obj;
		int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends