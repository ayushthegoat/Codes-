
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {

        vector<int> trustees(N + 1, 0);
        vector<int> trusters(N + 1, 0);

        for (auto it : trust) {
            int v = it[0];
            int u = it[1];

            trustees[v]++;
            trusters[u]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustees[i] == 0 && trusters[i] == N - 1)
                return i;
        }

        return -1;
    }
};