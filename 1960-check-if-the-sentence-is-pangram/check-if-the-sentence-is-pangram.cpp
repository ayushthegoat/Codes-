class Solution {
public:
    bool checkIfPangram(string sentence) {
        vector<int> res (26);
        for(int i=0;i<sentence.size();i++){
            char ch = sentence[i];
            res[ch -'a']++;
        }

        for(int i=0;i<res.size();i++){
            if(res[i]==0)return false;
        }

        return true;

    }
};
