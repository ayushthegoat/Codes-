//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int[] right=new int[n];
        int[] left=new int[n];
        int min=arr[0];
        int max=arr[n-1];
        for(int i=0;i<n;i++){
            if(arr[i]>min){
                  min=arr[i];
                 
            }
             right[i]=min;
            
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]<max){
                max=arr[i];
               
            }
             left[i]=max;
        }
        for(int i=0;i<n;i++){
            if(i!=0 && i!=n-1){
                if(left[i]==right[i])return left[i];
            }
        }
        return -1;
    }
}