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
        Map<Character, Integer> map = new HashMap<>();
            int maxcount=0;
         int j=0;
      
         for(int i=0;i<S.length();i++){
                  map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
                  
                  
                  while(map.get(S.charAt(i))>1){
                  if(map.containsKey(S.charAt(j))){
                       map.put(S.charAt(j),map.get(S.charAt(j))-1);
                      if(map.get(S.charAt(j))==0){
                         map.remove(S.charAt(j));
                            
                      }
                      j++;
                  }
                  
                  }
                  maxcount=Math.max(maxcount,i-j+1);
         }
         
             return maxcount;
         }
    }
