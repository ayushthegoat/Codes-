class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       

       boolean flag= false;
       for(int[] arr: matrix){
          boolean ans =  binarySearch(arr,target);
          if(ans)flag = true;
       }
       if(flag)return true;
       return false;

    }
    public boolean binarySearch(int[]arr,int target){
        int left=0;
        int right =arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;

            if(arr[mid]==target)return true;
            else if(arr[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}