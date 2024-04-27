class Solution {
public:
    int matrixSum(vector<vector<int>>& nums) {
        int row = nums.size();
        int col = nums[0].size();

        int total = 0;
        for(int i=0;i<nums.size();i++){
            sort(nums[i].begin(), nums[i].end());
        }

        for(int i=0;i<col;i++){
            int mx = 0;
            for(int j=0;j<row;j++){
                mx = max(mx,nums[j][i]);
            }
            total+=mx;
        }
        return total;

    }
};