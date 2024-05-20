class Solution {
    public String longestPrefix(String s) {
        char[] pat = s.toCharArray();
        int[] LPS = new int[pat.length];
         int len = 0; // length of previous longest prefix and suffix
    LPS[0] = 0;  // LPS[0] is always 0
        int i = 1;

        while (i < LPS.length) {
            if (pat[i] == pat[len]) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        for(int num : LPS)System.out.println(num+" ");
        return s.substring(0,LPS[pat.length-1]);
    }
}