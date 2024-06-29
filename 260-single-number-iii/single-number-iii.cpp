class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
         
        long long xo = 0;
        for(auto num : nums) {
            xo = (xo ^ num);
        }

        long long rsb = xo & -xo;
        int first = 0;
        int second = 0;

        for(auto num : nums) {
            if((rsb & num) == 0) {
                first = first ^ num;
            } else {
                second = second ^ num;
            }
        }
        if(first > second) {
            return {second, first};
        }
        return {first, second};
    }
};