class Solution {
public:
    int maskWord(string word) {
        int mask = 0;
        for(const auto it : word) {
            int bit = it-'a';
            mask = mask | (1<<bit);
        }
        return mask;
    }
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        unordered_map<int, int> mask_freq;
        for(auto word : words) {
            int mask = maskWord(word);
            mask_freq[mask]++;
        }
        vector<int> res;

        for(auto p : puzzles) {
            int mask = maskWord((p));
            int submask = mask;
            int first = (1<< (p[0]-'a'));
            int curr = 0;

            while(submask) {
                if(submask & first) {
                    curr += mask_freq[submask];

                }
                submask = (submask-1) & mask;
            }
            res.push_back(curr);
        }
        return res;
    }
};