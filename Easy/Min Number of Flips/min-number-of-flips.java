//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String S) {
        int min=Integer.MAX_VALUE;
        // Code here
        int c1=0;
        int c2=0;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            
            if (i % 2 == 0 && c == '1') {
                c1++;
            } else if (i % 2 == 1 && c == '0') {
                c1++;
            }

            if (i % 2 == 0 && c == '0') {
                c2++;
            } else if (i % 2 == 1 && c == '1') {
                c2++;
            }
            
        }
        return Math.min(c1,c2);
        
    }
}