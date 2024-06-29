class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
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

