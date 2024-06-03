//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Matrix {
  public:
    template <class T>
    static void input(vector<vector<T>> &A, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scanf("%d ", &A[i][j]);
            }
        }
    }

    template <class T>
    static void print(vector<vector<T>> &A) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A[i].size(); j++) {
                cout << A[i][j] << " ";
            }
            cout << endl;
        }
    }
};


// } Driver Code Ends

class Solution {
  public:
    int MinimumEffort(int rows, int columns, vector<vector<int>> &heights) {
        // code here
         int n = heights.size();
        int m = heights[0].size();
        
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
        vector<vector<int>> dist(rows+1, vector<int>(columns+1,1e9));
        pq.push({0,{0,0}});
        dist[0][0] = 0;
        
        
        const vector<pair<int,int>>directions = {
              {1,0},{0,1},{-1,0},{0,-1}
        };
        
        while(!pq.empty()){
            auto it = pq.top();
            pq.pop();
            int currDist = it.first;
            int row = it.second.first;
            int col = it.second.second;
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                      int new_effort = max(abs(heights[nrow][ncol] - heights[row][col]), currDist);
                      if(dist[nrow][ncol] > new_effort){
                          dist[nrow][ncol] = new_effort;
                          pq.push({new_effort, {nrow, ncol}});
                      }
                        
                    }
                }
            }
        
        return dist[n-1][m-1];
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int rows;
        scanf("%d", &rows);

        int columns;
        scanf("%d", &columns);

        vector<vector<int>> heights(rows, vector<int>(columns));
        Matrix::input(heights, rows, columns);

        Solution obj;
        int res = obj.MinimumEffort(rows, columns, heights);

        cout << res << endl;
    }
}

// } Driver Code Ends