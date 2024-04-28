class Solution {
public:
    vector<vector<int>> modifiedMatrix(vector<vector<int>>& matrix) {
         int row = matrix.size();
    int col = matrix[0].size();
    vector<int> store(col, INT_MIN); // Store the maximum value in each column

    // Find the maximum value in each column
    for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
            store[i] = max(store[i], matrix[j][i]);
        }
    }

    // Create a new matrix to store the modified values
    vector<vector<int>> answer(row, vector<int>(col));

    // Replace -1 with the maximum value in its respective column in the new matrix
    for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
            if (matrix[j][i] == -1) {
                answer[j][i] = store[i];
            } else {
                answer[j][i] = matrix[j][i];
            }
        }
    }

    return answer;
    }
};