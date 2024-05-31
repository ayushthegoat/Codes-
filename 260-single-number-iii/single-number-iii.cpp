class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        unordered_map<int,int>mp;
        
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
        }

        vector<int>res;
        for(auto it : mp){
            int nums = it.first;
            int count = it.second;
            if(count == 1){
                res.push_back(nums);
            }
        }
        return res;
    }
};