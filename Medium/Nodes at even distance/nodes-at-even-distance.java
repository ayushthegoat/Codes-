//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
            	graph.add(new ArrayList<>());
            }
            
            int temp = n;
            while(temp-- > 1){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Solution ob = new Solution();
            System.out.println(ob.countOfNodes(graph, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int val, level;
    Pair(int v, int l){
        val = v;
        level = l;
    }
}
class Solution
{
    int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        // Write your code here
        boolean[] visited = new boolean[n+1];
        Queue<Pair>q = new ArrayDeque();
        q.add(new Pair(1,0));
        int odd = 0;
        int even = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.val;
            int level = p.level;
            
           
            if(level%2==0) even++;
            else odd++;
            
            
            for(int iterator : graph.get(node)){
                if(visited[iterator] == false){
                     visited[node] = true;
                    q.offer(new Pair(iterator, level+1));
                }
            }
        }
        int peven = (even*(even-1))/2;
        int podd = (odd*(odd-1))/2;
        return (peven+podd);
    }
}