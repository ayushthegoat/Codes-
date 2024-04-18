//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        int rowBeg = 0;
        int rowEnd = matrix.length-1;
        int colBeg = 0;
        int colEnd = matrix[0].length-1;
        
        ArrayList<Integer> res = new ArrayList();
        
       
            
            for(int i=colBeg ;i<=colEnd; i++){
                 res.add(matrix[rowBeg][i]);
            }
            rowBeg++;
            
            for(int i=rowBeg ;i<=rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowBeg<=rowEnd){
            for(int i=colEnd; i>=colBeg; i--){
                res.add(matrix[rowEnd][i]);
             }
            }
            rowEnd--;
            
            if(colBeg<=colEnd){
            for(int i=rowEnd ;i>=rowBeg; i--){
                res.add(matrix[i][colBeg]);
             }
            }
            colBeg++;
        
        return res;
    }
}
