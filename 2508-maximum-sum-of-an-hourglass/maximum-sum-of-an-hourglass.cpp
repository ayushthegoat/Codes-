class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();

        int mx = 0;
        for(int i=1;i+1<row;i++){
            for(int j=1;j+1<col;j++){
                int sum = 0;
                sum+=grid[i][j];
                sum+=grid[i-1][j];
                sum+=grid[i-1][j-1];
                sum+=grid[i-1][j+1];
                sum+=grid[i+1][j];
                sum+=grid[i+1][j-1];
                sum+=grid[i+1][j+1];

                mx = max(mx,sum);
            }
            
        }
        return mx;
    }
};