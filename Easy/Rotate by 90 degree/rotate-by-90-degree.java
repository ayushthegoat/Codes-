//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) 
    { 
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swapper(matrix,i,j);
            }
        }
        for(int i=0;i<matrix.length;i++){
           int low=0;
           int high=matrix.length-1;
           while(low<high){
               int temp=matrix[low][i];
               matrix[low][i]=matrix[high][i];
               matrix[high][i]=temp;
               low++;
               high--;
           }
            
        }
        
        // code here
    }
    static void swapper(int mat[][],int ii,int jj){
        int temp=mat[ii][jj];
        mat[ii][jj]=mat[jj][ii];
       mat[jj][ii]=temp;
    }
}