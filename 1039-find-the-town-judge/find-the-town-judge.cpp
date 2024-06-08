
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {

        vector<int> trustees(N + 1, 0);
        vector<int> trusters(N + 1, 0);

        for (auto it : trust) {

            trustees[it[0]]++;
            trusters[it[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustees[i] == 0 && trusters[i] == N - 1)
                return i;
        }

        return -1;
    }
};