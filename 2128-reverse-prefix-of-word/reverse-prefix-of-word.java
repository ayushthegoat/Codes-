class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c==ch){
              arr = reverse(arr,i);
                break;
            }
        }
        for(char x:arr)System.out.print(x);
        return new String(arr);

    }
    private char[] reverse(char[] arr,int index){
        int i=0;
        int j=index;
        while(i<=j){
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
        return arr;
    }
}