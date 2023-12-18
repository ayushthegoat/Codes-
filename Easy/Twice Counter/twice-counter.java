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
                    int n = sc.nextInt();
                    String list[] = new String[n];
                    for(int i = 0;i<n;i++)
                        list[i] = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.countWords(list, n));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWords(String list[], int n)
    {  int counter=0;
        // code here 
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<list.length;i++){
            map.put(list[i],map.getOrDefault(list[i],0)+1);
        }
        for(String i:map.keySet()){
            if(map.get(i)==2){
                counter++;
            }
        }
        return counter;
    }
}