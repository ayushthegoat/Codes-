//{ Driver Code Starts
//Initial Template for C++


#include<bits/stdc++.h> 
using namespace std; 


// } Driver Code Ends
//User function Template for C++

class Solution {
public:
    int helpaterp(vector<vector<int>> hospital)
    {
        //code here
        int n = hospital.size();
        int m = hospital[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        queue<pair<int,pair<int,int>>> q;

        int mx = 0;
        
        for(int i=0 ;i<n ; i++){
            for(int j=0; j<m; j++){
                if(hospital[i][j] == 2){
                    q.push({0, {i, j}});
                    vis[i][j] = 1;
                    
            }
          }
        }
        const vector<pair<int,int>> directions = {
            {0,1},{1,0},{-1,0},{0,-1}
        };
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int row = it.second.first;
            int col = it.second.second;
            int steps = it.first;
            mx = max(steps, mx);
            
            for(const auto &dir : directions){
                int nrow = row + dir.first;
                int ncol = col + dir.second;
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && hospital[nrow][ncol]==1){
                    q.push({steps+1, {nrow, ncol}});
                    hospital[nrow][ncol] = 2;
                    vis[nrow][ncol] = 1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hospital[i][j]==1){
                    return -1;
                }
            }
        }
        return mx;
    }
};


//{ Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int R;int C;
        
        cin>>R>>C;
        vector<vector<int>> hospital;
        int i,j;
        for(i=0;i<R;i++)
         {   vector<int> temp;
             for(j=0;j<C;j++)
            {
                int k;
                cin>>k;
                temp.push_back(k);
            }
            hospital.push_back(temp);
         }
        
        Solution ob;
        int ans = ob.helpaterp(hospital);
        cout << ans << endl;
    }
    return 0;
}
// } Driver Code Ends