//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    int wordLadderLength(string startWord, string targetWord, vector<string>& wordList) {
        // Code here
        queue<pair<string, int>>q;
        q.push({startWord, 1});
        unordered_set<string>st(wordList.begin(), wordList.end());
        st.erase(startWord);
        
        while(!q.empty()){
            string curr = q.front().first;
            int steps = q.front().second;
            q.pop();
            
            if(curr == targetWord)return steps;
            
            for(int i=0;i<curr.size();i++){
                char original = curr[i];
                for(char ch='a'; ch<='z';ch++){
                    curr[i] = ch;
                    
                    if(st.find(curr)!=st.end()){
                        q.push({curr, steps+1});
                        st.erase(curr);
                    }
                    curr[i] = original;
                }
            }
        }
        return 0;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		int ans = obj.wordLadderLength(startWord, targetWord, wordList);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends