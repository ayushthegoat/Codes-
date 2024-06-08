//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution
{
  stack<pair<int, int>> stk;
public:
    int next(int price) {
        int span = 1;

        while (!stk.empty() && stk.top().first <= price) {
            span += stk.top().second;
            stk.pop();
        }

        stk.push({price, span});
        return span;
    }


vector<int> calculateSpan(int heights[], int n) {
    vector<int> res(n);
    Solution spanner;

    for (int i = 0; i < n; i++) {
        res[i] = spanner.next(heights[i]);
    }

    return res;
    }
};



//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int i,a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		Solution obj;
		vector <int> s = obj.calculateSpan(a, n);
		
		for(i=0;i<n;i++)
		{
			cout<<s[i]<<" ";
		}
		cout<<endl;
	}
	return 0;
}

// } Driver Code Ends