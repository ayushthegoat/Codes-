class Solution {
    public boolean isCircularSentence(String sentence) {
      int res = 0;
      String[] arr = sentence.split("\\s+");
      if (arr.length == 1 && sentence.charAt(0) == sentence.charAt(sentence.length() - 1)) {
       return true;
       }
       for(int i = 0; i < arr.length-1; i++) {
            char first = arr[i].charAt(arr[i].length()-1);
            char second = arr[i+1].charAt(0);
            if(first != second) {
                return false;
            }
       }
       if(sentence.charAt(0) == sentence.charAt(sentence.length()-1) ) {
        return true;
       }
       return false;
    }
}