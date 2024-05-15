//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        Map<Character,Integer>map = new HashMap<>();
        Queue<Character> q = new ArrayDeque();
        StringBuilder str = new StringBuilder();
        
        for(char ch : A.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(!q.contains(ch)){
                q.offer(ch);
                
            }
            while(!q.isEmpty() && map.get(q.peek())>1){
                q.poll();
            }
            if(q.isEmpty()){
                str.append("#");
            }else{
                str.append(q.peek());
            }
        }
        return str.toString();
    }
}