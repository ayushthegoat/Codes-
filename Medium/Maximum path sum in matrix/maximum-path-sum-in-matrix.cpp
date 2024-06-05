//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int maximumPath(int N, vector<vector<int>> mat)
    {
    int n = mat.size();
    if (n == 0) return 0;

    // Initialize the directions for BFS
    const vector<pair<int, int>> directions = {{1, 0}, {1, -1}, {1, 1}};

    // Create a 2D array to keep track of the maximum path sum to each cell
    vector<vector<int>> maxSum(n, vector<int>(n, INT_MIN));

    // Initialize the queue with the first row elements
    queue<pair<int, int>> q;
    for (int col = 0; col < n; ++col) {
        q.push({0, col});
        maxSum[0][col] = mat[0][col];
    }

    // BFS traversal
    while (!q.empty()) {
        auto it = q.front();
        
        q.pop();
        int row = it.first;
        int col = it.second;

        for (const auto& dir : directions) {
            int newRow = row + dir.first;
            int newCol = col + dir.second;

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                if (maxSum[newRow][newCol] < maxSum[row][col] + mat[newRow][newCol]) {
                    maxSum[newRow][newCol] = maxSum[row][col] + mat[newRow][newCol];
                    q.push({newRow, newCol});
                }
            }
        }
    }

    // Find the maximum path sum in the last row
    int maxPath = INT_MIN;
    for (int col = 0; col < n; ++col) {
        maxPath = max(maxPath, maxSum[n - 1][col]);
    }

    return maxPath;
        
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<vector<int>> Matrix(N, vector<int>(N, 0));
        for(int i = 0;i < N*N;i++)
            cin>>Matrix[(i/N)][i%N];
        
        Solution ob;
        cout<<ob.maximumPath(N, Matrix)<<"\n";
    }
    return 0;
}
// } Driver Code Ends