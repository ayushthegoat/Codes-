class Solution {
public:
    bool halvesAreAlike(string s) {
        int half = s.size() / 2;

        int ctr1 = 0;
        int ctr2 = 0;

        int i = s.size() - 1;
        while (i >= half) {
            if(checkVowel(s[i])){
                ctr1++;
            }
            i--;
        }
        i=0;
        while(i<half){
            if(checkVowel(s[i])){
                ctr2++;
            }
            i++;
        }
        return ctr1==ctr2;
    }
    bool checkVowel(char ch){
        string str="aeiouAEIOU";
        if(str.find(ch)!=string::npos){
            return true;
        }
        return false;
    }
};