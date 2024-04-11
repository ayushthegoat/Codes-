class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
      //  int[] memo = new int[nums.size()];

        vector<int> piles;

    for (int num : nums) {
        auto it = lower_bound(piles.begin(), piles.end(), num);

        if (it == piles.end()) {
            piles.push_back(num);
        } else {
            *it = num;
        }
    }

    return piles.size();
    }
};