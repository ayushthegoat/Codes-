//{ Driver Code Starts
// Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode
{

    class GFG
    {
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {
                string txt = Console.ReadLine().Trim();
                string pat = Console.ReadLine().Trim();
                Solution obj = new Solution();
                int res = obj.search(pat, txt);
                Console.Write(res+"\n");
            }

        }
    }
}

// } Driver Code Ends


//User function template for C#
class Solution{
    //Complete this function
      private bool Checker(int[] windowCount, int[] patCount) {
        for (int i = 0; i < 26; i++) {
            if (windowCount[i] != patCount[i]) {
                return false;
            }
        }
        return true;
    }

    public int search(string pat, string txt) {
        int counter = 0;

        if (pat.Length > txt.Length) return counter;

        int[] patCount = new int[26];
        int[] windowCount = new int[26];

        // Count frequencies of characters in the pattern
        for (int i = 0; i < pat.Length; i++) {
            patCount[pat[i] - 'a']++;
        }

        // Initialize the window count for the first window
        for (int i = 0; i < pat.Length; i++) {
            windowCount[txt[i] - 'a']++;
        }

        // Check if the first window matches the pattern
        if (Checker(windowCount, patCount)) {
            counter++;
        }

        // Slide the window across the text
        for (int i = pat.Length; i < txt.Length; i++) {
            // Add the new character to the window
            windowCount[txt[i] - 'a']++;
            // Remove the character that is no longer in the window
            windowCount[txt[i - pat.Length] - 'a']--;

            // Check if the current window matches the pattern
            if (Checker(windowCount, patCount)) {
                counter++;
            }
        }

        return counter;
    }
}