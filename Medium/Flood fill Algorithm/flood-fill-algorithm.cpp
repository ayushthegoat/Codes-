//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
private:
//     void solve(int row,int col,vector<vector<int>>& answer,vector<vector<int>>& answer,int initial,int newColor
//     ,vector<int>delcol,vector<int>delcol){
//         answer[row][col] = newColor;
//         for(int i=0;i<4;i++){
//             int nrow = row+delcol[i];
//             int ncol = col+delcol[i];
//             if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && image[nrow][ncol]==initial && answer[nrow][ncol]!=newColor){
//                 solve(nrow,ncol,answer,image,initial,newColor,delrow,delcol);
//             }
//         }
// }
 void solve(int row, int col, vector<vector<int>>& answer, const vector<vector<int>>& image, int initial, int newColor, const vector<int>& delrow, const vector<int>& delcol) {
        answer[row][col] = newColor;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < image.size() && ncol >= 0 && ncol < image[0].size() && image[nrow][ncol] == initial && answer[nrow][ncol] != newColor) {
                solve(nrow, ncol, answer, image, initial, newColor, delrow, delcol);
            }
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        // Code here 
        vector<vector<int>>answer = image;
        vector<int>delrow = {-1,0,1,0};
        vector<int>delcol = {0,1,0,-1};
        int initial = image[sr][sc];
        solve(sr,sc,answer,image,initial,newColor,delrow,delcol);
        return answer;
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