//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java
class TrieNode{
    TrieNode child[] = new TrieNode[26];
    int count = 0;
    String word = "";
    
    TrieNode(){}
}

class Solution
{
    public TrieNode root;
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        // code here
        root = new TrieNode();
        int res = 0;
        String ans = "";
        
        HashMap<Integer,String> map = new HashMap();
        
        for(int i=arr.length-1;i>=0;i--){
            TrieNode temp = root;
            String str = arr[i];
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                int idx = ch - 'a';
                if(temp.child[idx]==null){
                    temp.child[idx] = new TrieNode();
                }
                temp = temp.child[idx];
            }
            temp.word = str;
            temp.count +=1;
            if(temp.count>res){
                res = temp.count;
                ans = "";
                ans = temp.word;
            }
        }
        return ans;
    }

}


//{ Driver Code Starts.
// } Driver Code Ends