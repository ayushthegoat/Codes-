//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
       HashMap<Character,Integer> stringa=new HashMap<>();
       HashMap<Character,Integer> stringb=new HashMap<>();
       
       char[] stra=a.toCharArray();
       char[] strb=b.toCharArray();
       
       
       for(char i:stra){
           stringa.put(i,stringa.getOrDefault(i,0)+1);
           
       }
        for(char i:strb){
           stringb.put(i,stringb.getOrDefault(i,0)+1);
           
       }
      if(stringa.size()!=stringb.size())
      {
          return false;
      }
      for(char c:stringa.keySet())
      {
          if(!stringb.containsKey(c) || !stringb.get(c).equals(stringa.get(c))){
              return false;
          }
      }
      return true;
        
    }
}