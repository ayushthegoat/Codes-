//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
         Set<Character>set=new LinkedHashSet<>();
         int curcount=0;
         int maxcount=0;
         char[]arr=S.toCharArray();
          for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                curcount++;
                maxcount = Math.max(curcount, maxcount);
            } else {
                i =i- curcount; 
                set.clear();
                curcount = 0;
            }
        }

        return maxcount;
         }
    }
