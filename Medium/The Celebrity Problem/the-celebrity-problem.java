//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here
    	Stack<Integer>stk=new Stack<>();
    	for(int i=0;i<arr.length;i++){
    	    stk.push(i);
    	}
    	while(stk.size()>=2){
    	    int c1=stk.pop();
    	    int c2=stk.pop();
    	    
    	    if(arr[c1][c2]==1){
    	        stk.push(c2);
    	    }else{
    	        stk.push(c1);
    	    }
    	}
    	int can=stk.pop();
    	for(int i=0;i<arr.length;i++){
    	    if(i!=can){
    	        if(arr[can][i]==1 || arr[i][can]==0)return -1;
    	    }
    	}
    	return can;
    }
}