//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class gfg
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String s[] = read.readLine().trim().split("\\s+");
            
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            
            int arr[] = new int[N];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < N; i++)
            {
                arr[i] = Integer.parseInt(st[i]);
            }
            
            Solution obj = new Solution();
            
            System.out.println(obj.ternarySearch(arr, N, K));
        }
    }
}
// } Driver Code Ends



class Solution{

    static int ternarySearch(int arr[], int N, int K)
    {
        // Your code here
           int i=0;
        int j=N-1;
        int mid=0;
        while(i<=j){
             mid=i+(j-i)/2;
            if(K==arr[mid]){
                return 1;
            }else if(arr[mid]>K){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return -1;
    }
}