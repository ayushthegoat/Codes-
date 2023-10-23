//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
           HashMap<Character, Integer> charCountMap = new HashMap<>();
    int max = 0;
    char[] newarr = line.toCharArray();

    for (char i : newarr) {
        charCountMap.put(i, charCountMap.getOrDefault(i, 0) + 1);
    }

    char[] storingarr = new char[50];
    int index = 0;

    for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
        if (entry.getValue() >= max) {
            if (entry.getValue() > max) {
                index = 0;  
                max = entry.getValue();
            }
            storingarr[index] = entry.getKey();
            index++;
        }
    }

    Arrays.sort(storingarr, 0, index); 

    return storingarr[0];
}
}