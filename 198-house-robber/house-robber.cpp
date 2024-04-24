class Solution {
public:
    int t[101];
    int rob(vector<int>& nums) {
        int n = nums.size();
        memset(t,-1,sizeof(t));

        return solve(nums , 0, n);
    }
    int solve(vector<int>&nums, int i, int n){
        if(i>=n){
            return 0;
        }
        if(t[i]!=-1){
            return t[i];
        }

        int steal = nums[i] + solve(nums , i+2 ,n);
        int skip = solve(nums, i+1, n);

        t[i] = max(steal ,skip);

        return t[i];
    }
};