class Solution {
public:
    int tribonacci(int n) {
        vector<int> hash(n+10);
         hash[0] = 0;
         hash[1] = 1;
         hash[2] = 1;

         for(int i=3;i<=n;i++){
            hash[i] = hash[i-1] + hash[i-2] + hash[i-3];
         }
         return hash[n];
    }
};