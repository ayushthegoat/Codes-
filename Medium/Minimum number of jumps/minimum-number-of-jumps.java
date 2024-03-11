//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        if (arr[0] == 0)
            return -1;
        if (arr.length == 1)
            return 0;
        int jumps=1;
        int maxEnd=arr[0];
        int lastJump=arr[0];
        
        for(int i=0;i<arr.length;i++){
            if(lastJump>=arr.length){
                return jumps;
            }
            
            if(i>lastJump){
                return -1;
            }
            int currentEnd=i+arr[i];
            
            if(maxEnd<currentEnd){
                maxEnd=currentEnd;
            }
            
            if(i==lastJump){
                jumps++;
                lastJump=maxEnd;
            }
        }
        return jumps-1;
    }
}