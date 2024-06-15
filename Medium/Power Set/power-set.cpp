//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	    void solve(vector<string>&res, string& str,string &s, int index) {
	        if(index >= s.size()) {
	            res.push_back(str);
	            return;
	        }
	        
	        
	        solve(res, str, s, index+1);
	        str.push_back(s[index]);
	        solve(res, str, s, index+1);
	        str.pop_back();
	        
	        
	    }
		vector<string> AllPossibleStrings(string s){
		    // Code here
		    vector<string>res;
		    string str = "";
		    
		    solve(res, str, s, 0);
		    sort(res.begin(), res.end());
		    res.erase(remove(res.begin(), res.end(), ""), res.end());
		    
		    return res;
		}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		Solution ob;
		vector<string> res = ob.AllPossibleStrings(s);
		for(auto i : res)
			cout << i <<" ";
		cout << "\n";

	}
	return 0;
}
// } Driver Code Ends