//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
   if(n<3){
	        return false;
	    }
	    Arrays.sort(arr);
	    for(int i=n-1;i>=2;i--){
	        int sum1=arr[i]*arr[i];
	        int a=0,b=i-1;
	        while(a<b){
	            if(arr[i]==arr[i-1]){
	                break;
	            }
	            int sum2=(arr[a]*arr[a])+(arr[b]*arr[b]);
	            if(sum1==sum2){
	                return true;
	            }
	            else if(sum1>sum2){
	                a++;
	            }
	            else{
	                b--;
	            }
	        }
	    }
	    return false;
        }
}