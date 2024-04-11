class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
         
         for(int[] s: image){
            solve(s);
         }
         for(int[] s: image){
             for(int i=0;i<s.length;i++){
                if(s[i]==0){
                    s[i]=1;
                }else{
                    s[i]=0;
                }
            }
         }
         return image;

    }
    public void solve(int[] arr){
            int i =0;
            int j =arr.length-1;
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        
    }
}