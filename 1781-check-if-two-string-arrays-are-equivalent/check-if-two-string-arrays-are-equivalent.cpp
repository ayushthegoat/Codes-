class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string str1="";
        string str2="";
        for(string &iterator : word1){
            str1+=iterator;
        }
        for(string &iterator : word2){
            str2+=iterator;
        }
        return str1==str2;
    }
};