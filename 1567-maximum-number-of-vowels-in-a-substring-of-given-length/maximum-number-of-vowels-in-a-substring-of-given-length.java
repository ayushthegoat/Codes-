class Solution {
    public int maxVowels(String s, int k) {
     int[] vowels=new int[26];
     vowels['a'-'a']=1;
     vowels['e'-'a']=1;
     vowels['i'-'a']=1;
     vowels['o'-'a']=1;
     vowels['u'-'a']=1;
     
     int maxVowels=0;
     int curr=0;

     for(int i=0;i<k;i++){
       char ch=s.charAt(i);
       if(vowels[ch-'a']==1)curr++;
     }
     maxVowels=curr;

    for(int i=k;i<s.length();i++){
        char chAdded=s.charAt(i);
        char chRemoved=s.charAt(i-k);
        if(vowels[chRemoved-'a']==1)curr--;

        if(vowels[chAdded-'a']==1)curr++;

        maxVowels=Math.max(maxVowels,curr);
    }



        return maxVowels;
    }
}