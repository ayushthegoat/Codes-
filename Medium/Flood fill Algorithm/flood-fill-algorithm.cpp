//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
private:
   void dfs(int sr,int sc, vector<vector<int>>&res, vector<vector<int>>&image,int newColor,int initial){
       static const vector<pair<int, int>> directions = {
                    {-1,0},
             {0,-1},       {0,+1},
                    {+1,0}       
        };
        
        res[sr][sc] = newColor;
        
        queue<pair<int,int>>q;
        q.push({sr, sc});
        
        while(!q.empty()){
            int row = q.front().first;
            int col = q.front().second;
            q.pop();
            
            
            for(const auto& dir: directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                if(nrow>=0 && nrow<image.size() && ncol>=0 && ncol<image[0].size() &&
                image[nrow][ncol] == initial && res[nrow][ncol] !=newColor){
                    
                    res[nrow][ncol] = newColor;
                    q.push({nrow, ncol});
                }
            }
        }
        
   }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        // Code here 
     vector<vector<int>>res = image;
     int initial = image[sr][sc];
     
     dfs(sr,sc,res,image,newColor,initial);
     
     return res;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>image(n, vector<int>(m,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> image[i][j];
		}
		int sr, sc, newColor;
		cin >> sr >> sc >> newColor;
		Solution obj;
		vector<vector<int>> ans = obj.floodFill(image, sr, sc, newColor);
		for(auto i: ans){
			for(auto j: i)
				cout << j << " ";
			cout << "\n";
		}
	}
	return 0;
}
// } Driver Code Ends