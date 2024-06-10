//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	int minStepToReachTarget(vector<int>&KnightPos, vector<int>&TargetPos, int N){
	    // Code here
	     const vector<pair<int, int>> directions = {
           {2, 1}, {2, -1}, {-2, 1}, {-2, -1},  // Moves where the knight moves two squares vertically and one square horizontally
           {1, 2}, {1, -2}, {-1, 2}, {-1, -2}   // Moves where the knight moves one square vertically and two squares horizontally
      };
      
      vector<vector<bool>>vis (N, vector<bool>(N,false));
      int startRow = KnightPos[0] - 1;
      int startCol  =KnightPos[1] - 1;
      
      int endRow = TargetPos[0] - 1;
      int endCol = TargetPos[1] - 1;
      
      vis[startRow][startCol] = true;
      
      queue<pair<int, pair<int,int>>>q;
      q.push({0,{startRow, startCol}});
      int mini = INT_MAX;
      
      while(!q.empty()) {
          int steps = q.front().first;
          int row = q.front().second.first;
          int col = q.front().second.second;
          q.pop();
          
          
          for(const auto &dir : directions) {
              int nrow = row + dir.first;
              int ncol = col + dir.second;
              
              if(nrow>=0 && nrow<N && ncol>=0 && ncol<N && !vis[nrow][ncol]) {
                  
                  vis[nrow][ncol] = true;
                  q.push({steps+1, {nrow, ncol}});
              }
          }
      }
      return mini!=INT_MAX ? mini: -1;
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