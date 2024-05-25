class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int r = heights.size();
    int c = heights[0].size();
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
    pq.push({0, {0, 0}});
    vector<vector<int>> did(r, vector<int>(c, 1e9));
    did[0][0] = 0;
    const vector<pair<int, int>> directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    while (!pq.empty()) {
        auto it = pq.top();
        pq.pop();
        int dist = it.first;
        int row = it.second.first;
        int col = it.second.second;

        if (row == r - 1 && col == c - 1) {
            return dist;
        }

        for (const auto& dir : directions) {
            int nrow = row + dir.first;
            int ncol = col + dir.second;

            if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c) {
                int effort = max(abs(heights[row][col] - heights[nrow][ncol]), dist);
                if (effort < did[nrow][ncol]) {
                    did[nrow][ncol] = effort;
                    pq.push({effort, {nrow, ncol}});
                }
            }
        }
    }
    return -1;
    }
};