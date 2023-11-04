//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) {
   char[] c=s.toCharArray();
  String str="";
   Map<Character,Integer>map=new LinkedHashMap<>();
   
   
   for(char i:c){
       map.put(i,map.getOrDefault(i,0)+1);
       if(map.get(i)==2)
       {
           return str+i;
       }
   }
  
   str+="-1";
   return str;
    }
} 