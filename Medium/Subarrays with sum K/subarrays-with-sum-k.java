//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        int cursum=0;
        int j=0;
        int counter=0;
              
              Map<Integer,Integer>map=new HashMap<>();
              
              for(int i=0;i<Arr.length;i++){
                  cursum=cursum+Arr[i];
                  
                  if(cursum==k){
                      counter++;
                  }
                  
                  if(map.containsKey(cursum-k)){
                      counter=counter+map.get(cursum-k);
                  }
                  map.put(cursum,map.getOrDefault(cursum,0)+1);
                  
                  
              }
              
    return counter;
    }
}