//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{

    public:
    vector<vector<int> > findDistance(vector<vector<char> >& matrix, int N, int M) 
    { 
        // Your code goes here
         vector<vector<int>>grid(N,vector<int>(M,-1));
         vector<vector<int>>vis(N,vector<int>(M,0));
           queue<pair<int,pair<int,int>>>q;
           const vector<pair<int,int>> directions = {{1,0},{0,1},{-1,0},{0,-1}};
           
           for(int i=0;i<N;i++){
               for(int j=0;j<M;j++){
                   if(matrix[i][j] == 'B'){
                       q.push({0,{i,j}});
                       grid[i][j] = 0;
                       vis[i][j] = 1;
                   }
               }
           }
           
           while(!q.empty()){
               auto it = q.front();
               q.pop();
               int steps = it.first;
               int row = it.second.first;
               int col = it.second.second;
               
             for (const auto &dir : directions) {
                 int nrow = row + dir.first;
                 int ncol = col + dir.second;
    
               if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M && !vis[nrow][ncol] && matrix[nrow][ncol] == 'O') {
                       grid[nrow][ncol] = steps + 1;
                       q.push({steps+1, {nrow, ncol}});
                       vis[nrow][ncol] = 1;
                   }
               }
           }
           return grid;
          
    } 
};

//{ Driver Code Starts.


int main()
{

    int t;
    cin >> t;
    while(t--)
    {
    	int M,N;
        cin>>M;
        cin>>N;

        vector<vector<char> > matrix(M);
        for(int i=0; i<M; ++i)
        {
            matrix[i].resize(N);
            for (int j = 0; j < N; ++j)
                cin>>matrix[i][j];
        }

        vector<vector<int> >result;
        Solution obj;
        result = obj.findDistance(matrix, M,N); 
        for(int i=0; i<M; ++i)
        {
            for (int j = 0; j < N; ++j)
                cout<<result[i][j]<<" ";
            cout<<"\n";
        }
    }

    return 0;
}
// } Driver Code Ends