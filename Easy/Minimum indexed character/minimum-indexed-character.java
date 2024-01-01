//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            String patt = br.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.printMinIndexChar(str, patt));
        }
    }
}
// } Driver Code Ends


class Solution{
    
    // Function to find the character in patt which is present in str at min index
    public static String printMinIndexChar(String S, String patt){
        
        // Your code here
        
        // you don't need to print anything
         Map<Character,Integer>map=new HashMap<>();
         
         for(int i=0;i<patt.length();i++)
         {
             if(map.containsKey(patt.charAt(i))){
                 map.put(patt.charAt(i),1);
             }else{
                 map.put(patt.charAt(i),map.getOrDefault(patt.charAt(i),0)+1);
             }
         }
         for(int i=0;i<S.length();i++){
             if(map.containsKey(S.charAt(i))){
                 return String.valueOf(S.charAt(i));
             }
         }
         return "$";
    }
    
}
