//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        if(a.length==1)return a[0];
        int res=passOne(a);
    
        if(res<0){
         int maxneg=a[0];
         for(int i=0;i<a.length;i++){
            maxneg=Math.max(maxneg,a[i]);
         }
         return maxneg;
        }
        int summ=0;
        for(int i=0;i<a.length;i++){
            summ=summ+a[i];
            a[i]=-a[i];
          
        }
        
        
        int cicularsum=summ+passOne(a);
        return Math.max(cicularsum,res);
      
    
    }
      static int passOne(int[]arr){
           int sum=0;
           int max=arr[0];
           for(int i=0;i<arr.length;i++){
               sum=sum+arr[i];
               if(sum<arr[i]){
                   sum=arr[i];
               }
               max=Math.max(sum,max);
           }
           return max;
       }
    
}

