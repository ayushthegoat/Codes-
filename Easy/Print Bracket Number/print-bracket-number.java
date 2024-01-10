//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for(int value :  result)
                out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String S) {
        // code here
        Stack<Integer>stk=new Stack<>();
        ArrayList<Integer>list=new ArrayList<>();
        boolean check=false;
        int ctr=1;
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                stk.push(ctr);
                list.add(ctr);
                ctr++;
            } else if (c == ')') {
                list.add(stk.pop());
            }
        }
        return list;
    }
};