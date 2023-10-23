//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {String ss="";
    char[] arrayA=A.toCharArray();
    char[] arrayB=B.toCharArray();
    
    Set<Character> set1 =new HashSet<>();
    Set<Character> set2 =new HashSet<>();
    
        for(char i:arrayA)
        {
            set1.add(i);
            
        }
        for(char i:arrayB)
    {
        set2.add(i);
    }
   HashSet<Character>uncommon = new HashSet<>();
   for(char i:set1)
   {
       if(!set2.contains(i)){
          uncommon.add(i);}
   }
   for(char i:set2)
   {
       if(!set1.contains(i))
       {
        uncommon.add(i);}   
       
   }
    if(uncommon.size()==0)
   {
      ss= "-1";
   }
 
   List<Character> li=new ArrayList<>(uncommon);
   Collections.sort(li);
   for(int i=0;i<li.size();i++)
   {
       ss=ss+li.get(i);
       
   }
  return ss;
    }
   
   
}