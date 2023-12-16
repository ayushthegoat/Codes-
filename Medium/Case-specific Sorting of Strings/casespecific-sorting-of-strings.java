//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {StringBuilder sb=new StringBuilder ();
        // Your code here
   char[] small = new char[100000];
char[] big = new char[100000];
int si = 0;
int bi = 0;

for (int i = 0; i < str.length(); i++) {
    char currentChar = str.charAt(i);
    if (Character.isUpperCase(currentChar)) {
        big[bi++] = currentChar;
    } else {
        small[si++] = currentChar;
    }
}



Arrays.sort(small,0,si);
Arrays.sort(big,0,bi);
si = 0;
bi = 0;

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (Character.isLowerCase(ch)) {
        sb.append(small[si++]);
    } else {
        sb.append(big[bi++]);
    }
}

return sb.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends