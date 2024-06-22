class Solution {
public:
    int rob(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return max(arr[0], arr[1]);

        int prev = max(arr[0], arr[1]);
        int prevPrev = arr[0];
        int mx = prev;
        
        for(int i=2;i<n;i++){
            int steal = arr[i] + prevPrev;
            int skip = prev;
            
            mx = max(steal,skip);

            prevPrev = prev;
            prev = mx;
        }
    
        return mx;
    }
};