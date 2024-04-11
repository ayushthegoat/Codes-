class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
      //  int[] memo = new int[nums.size()];

        vector<int>memo (nums.size());

        for(int i=1;i<nums.size();i++){
            for(int j=0 ;j<i ;j++){
                if(nums[i] > nums[j]){
                    if(memo[j] + 1>memo[i]){
                        memo[i] = memo[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<memo.size();i++){
            if(memo[i]>memo[max]){
                max= i;
            }
        }
        return memo[max]+1;
    }
};