class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(s.length() == 1) return s;

        String LPS = "";
        char[] arr = s.toCharArray();

        for(int i=1;i<n;i++) {
            //for odd
            int low = i;
            int high = i;

            while(arr[low] == arr[high]) {
                low--;
                high++;

                if(low == -1 || high == n) {
                   break;
                }
            }

            String pallindrome = s.substring(low+1, high);
            if(pallindrome.length() > LPS.length()) {
                LPS = pallindrome;
            }

            //for even 
            low = i - 1;
            high = i;

            while(arr[low] == arr[high]) {
                low--;
                high++;

                if(low == -1 || high == n) {
                    break;
                }
            }

            pallindrome = s.substring(low+1, high);
            if(pallindrome.length() > LPS.length()) {
                LPS = pallindrome;
            }
        }

        return LPS;
    }
}