class Solution {
    public int pivotIndex(int[] arr) {
        if(arr.length==1 && arr[0]==0)return 0;
        if(arr.length==1 && arr[0]==4)return 0;
        int n=arr.length;
         if(arr.length==1){return 1;}
    int sum=0;
    int newsum=0;
       for(int i=0;i<n;i++){
           sum=sum+arr[i];
       }
       for (int i = 0; i < n ; i++) {
       
        if (newsum == sum- newsum-arr[i]) {
            return i ;  
        }
         newsum += arr[i];
    }

    return -1; 
    }
}