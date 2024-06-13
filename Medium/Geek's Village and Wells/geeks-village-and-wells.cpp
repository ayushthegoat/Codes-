//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    vector<vector<int>> chefAndWells(int n,int m,vector<vector<char>> &c){
        // Code here
          vector<vector<int>>ans(n,vector<int>(m,-1));
        queue<pair<int, int>>q;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(c[i][j]=='W')
                {
                    ans[i][j]=0;
                    q.push({i,j});
                }
            }
        }
        
        vector<int>x={0,0,1,-1};
        vector<int>y={1,-1,0,0};
        
        int steps=2;
        while(!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                pair<int,int>temp=q.front();
                q.pop();
                for(int k=0;k<4;k++)
                {
                    int i=temp.first+x[k];
                    int j=temp.second+y[k];
                    
                    if( i>=0 && j>=0 && i<n && j<m && ans[i][j]==-1 && c[i][j]=='H')
                    {
                        ans[i][j]=steps;
                        q.push({i,j});
                    }
                    else if( i>=0 && j>=0 && i<n && j<m && ans[i][j]==-1 && c[i][j]=='.')
                    {
                        ans[i][j]=0;
                        q.push({i,j});
                    }
                }
                
            }
            steps=steps+2;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(c[i][j]=='N' || c[i][j]=='.')
                {
                    ans[i][j]=0;
                }
            }
        }
        
        return ans ;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        vector<vector<char>> c(n,vector<char>(m));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin>>c[i][j];
            }
        }
        Solution ob;
        vector<vector<int>> res=ob.chefAndWells(n,m,c);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cout<<res[i][j]<<" ";
            }
            cout<<endl;
        }
    }
}
// } Driver Code Ends