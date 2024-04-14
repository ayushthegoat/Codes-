class Solution {
public:
    int diagonalPrime(vector<vector<int>>& nums) {
        int row = nums.size();
        int col = nums[0].size();
        int mx = -1;

        for (int i = 0; i < row; i++) {
           if(isPrime(nums[i][i])){
             mx = max(mx,nums[i][i]);
           }
           if(isPrime(nums[i][row-1-i])){
            mx = max(mx,nums[i][row-1-i]);
           }
        }
        return mx!=-1?mx:0 ;
    }
    bool isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
};