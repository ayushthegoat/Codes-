class Solution {
    public String reverseVowels(String s) {
       
    int i = 0;
    int j = s.length() - 1;
    char[] chars = s.toCharArray(); 

    while (i < j) {
        char atI = chars[i];
        char atJ = chars[j];

        if (isVowel(atI) && isVowel(atJ)) {
            chars[i] = atJ;
            chars[j] = atI;
            i++;
            j--;
        } else if (isVowel(atI)) {
            j--;
        } else if (isVowel(atJ)) {
            i++;
        } else {
            i++;
            j--;
        }
    }
    return new String(chars);
       

    }
    public boolean isVowel(char c){
        String vowels="aeiouAEIOU";
       
        return vowels.indexOf(c)!=-1;
    }
}