class Solution {
    public String longestPrefix(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int len = 0;
        int max = 0;
        int[] LP = new int[n];
        int i = 1;

        while(i<n){
            if(str[i] == str[len]){
                len++;
                LP[i] = len;
                i++;
            }else {
                if(len!=0){
                    len = LP[len-1];

                }else{
                    LP[i] = 0;
                    i++;
                    
                }
            }
        }
        for(int num : LP)max = Math.max(num, max);
        return s.substring(0,LP[n-1]);
    }
}