//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
  int n;
    int m;
    vector<pair<int, int>> directions = {
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    bool isValid(vector<vector<char>>& grid, int row, int col, int index, string& word) {
        // Check bounds first
        if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == word[index]) {
            return true;
        }
        return false;
    }

    bool dfs(vector<vector<char>>& grid, string& word, int row, int col, int index, int dir) {
        if (index == word.size()) {
            return true;
        }
        
        int newRow = row + directions[dir].first;
        int newCol = col + directions[dir].second;

        if (isValid(grid, newRow, newCol, index, word)) {
            return dfs(grid, word, newRow, newCol, index + 1, dir);
        }

        return false;
    }

    vector<vector<int>> searchWord(vector<vector<char>>& grid, string word) {
        n = grid.size();
        m = grid[0].size();
        vector<vector<int>> result;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word[0]) {
                    for (int dir = 0; dir < 8; dir++) {
                        if (dfs(grid, word, i, j, 1, dir)) {
                            result.push_back({i, j});
                            break; // Only add the starting position once
                        }
                    }
                }
            }
        }

        // Ensure the result is lexicographically smallest
        sort(result.begin(), result.end());
        return result;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<char>>grid(n, vector<char>(m,'x'));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> grid[i][j];
		}
		string word;
		cin >> word;
		Solution obj;
		vector<vector<int>>ans = obj.searchWord(grid, word);
		if(ans.size() == 0)
		{
		    cout<<"-1\n";
		}
		else
		{
		    for(auto i: ans){
			for(auto j: i)
				cout << j << " ";
			cout << "\n";
		    }
		}
		
		
	}
	return 0;
}
// } Driver Code Ends