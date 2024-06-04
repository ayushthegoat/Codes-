//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    int minimumCost(vector<vector<int>>& flights, int n, int k) {
        // code here
        vector<pair<int,int>> adj[n+1];
        vector<int> distance(n+1,1e9);
        distance[k]=0;
        int ans=INT_MIN;
        for(auto x:flights){
            adj[x[0]].push_back({x[1],x[2]});
        };
        priority_queue<pair<int,int>> q;
        q.push({0,k});
        while(!q.empty()){
            int a=q.top().second;
            q.pop();
            for(auto u:adj[a]){
                int b=u.first;
                int w=u.second;
                if(distance[a]+w<distance[b]){
                    distance[b]=distance[a]+w;
                    q.push({-distance[b],b});
                }
            }
        }
        for(int i=1;i<n+1;i++){
            ans=max(ans,distance[i]);
        }
        return ans!=1e9?ans:-1;
    
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int size;
        cin >> size;
        vector<vector<int>> flights(size,vector<int>(3));
        for (int i = 0; i < size; i++) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            flights[i]=temp;
        }

        Solution ob;
        cout << ob.minimumCost(flights, n, k) << "\n";
    }
}

// } Driver Code Ends