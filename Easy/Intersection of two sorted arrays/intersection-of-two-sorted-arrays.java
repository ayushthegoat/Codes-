//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
                arr1[i] = Integer.parseInt(st[i]);
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < M; i++)
                arr2[i] = Integer.parseInt(st[i]);
                
            ArrayList<Integer> v = new ArrayList<Integer>();
            v = new Solution().printIntersection(arr1, arr2, N, M);
           
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+" ");
                
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> printIntersection(int arr1[], int arr2[], int n, int m) 
    {
        // add your code here
     //   Set<Integer>set=new HashSet<>();
        ArrayList<Integer>list=new ArrayList<>();
        int[] res=new int[1000000];
        for(int i=0;i<arr1.length;i++){
            res[arr1[i]]++;
        }
        for(int i=0;i<arr2.length;i++){
            if(res[arr2[i]]>0)list.add(arr2[i]);
            res[arr2[i]]=0;
        }
        return list;
    }

}

