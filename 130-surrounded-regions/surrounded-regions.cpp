class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        queue<pair<int, int>> q;
        vector<int> numOfX(board.size());

        // Add boundary 'O' cells to the queue and mark them as visited
        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                q.push({i, 0});
                board[i][0] = 'T'; // Temporarily mark as visited
            }
            if (board[i][m - 1] == 'O') {
                q.push({i, m - 1});
                board[i][m - 1] = 'T'; // Temporarily mark as visited
            }
        }
        for (int j = 1; j < m - 1; ++j) {
            if (board[0][j] == 'O') {
                q.push({0, j});
                board[0][j] = 'T'; // Temporarily mark as visited
            }
            if (board[n - 1][j] == 'O') {
                q.push({n - 1, j});
                board[n - 1][j] = 'T'; // Temporarily mark as visited
            }
        }

        const vector<pair<int, int>> directions = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // Perform BFS starting from the boundary 'O' cells
        while (!q.empty()) {
            auto [row, col] = q.front();
            q.pop();

            // Check neighbors
            vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (const auto& dir : dirs) {
                int newRow = row + dir.first;
                int newCol = col + dir.second;
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    board[newRow][newCol] == 'O') {
                    q.push({newRow, newCol});
                    board[newRow][newCol] = 'T'; // Temporarily mark as visited
                }
            }
        }

        // Convert remaining 'O's to 'X's and revert 'T's back to 'O's
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
};