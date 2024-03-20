class Solution {
    public int maxVowels(String s, int k) {
    Set<Character>set=new HashSet<>();
    set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');

      int maxVowels=0;
      int currCount=0;

      for(int i=0;i<k;i++){
        if(set.contains(s.charAt(i)))currCount++;
      }
      maxVowels=currCount;
      for(int i=k;i<s.length();i++){
        if(set.contains(s.charAt(i-k)))currCount--;

        if(set.contains(s.charAt(i)))currCount++;

        maxVowels=Math.max(maxVowels,currCount);
      }
        
        return maxVowels;
    }
}