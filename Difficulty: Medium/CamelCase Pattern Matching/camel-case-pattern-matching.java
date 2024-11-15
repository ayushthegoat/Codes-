//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] arr = sc.nextLine().split(" ");

            String pat = sc.nextLine();

            Solution ob = new Solution();
            List<String> ans = ob.camelCase(arr, pat);
            if (ans.isEmpty()) {
                System.out.println("[]");
            } else {
                // Sort results before printing
                Collections.sort(ans);
                System.out.println(String.join(" ", ans));
            }
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        // code here
        List<String> ans = new ArrayList<>();
        for(String temp : arr) {
            String curr = temp;
            String capital = "";
            for(int i = 0; i < curr.length(); i++) {
                char c = curr.charAt(i);
                if(Character.isUpperCase(c)) {
                    capital += c;
                }
            }
             if(matcher(capital, pat)) {
                    ans.add(curr);
            }
        }
        return ans;
    }
    private boolean matcher(String curr, String pat) {
        int i = 0;
        int j = 0;
        int len1 = curr.length();
        int len2 = pat.length();
        while(i < len1 && j < len2) {
            if(curr.charAt(i) != pat.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        if(j == len2) return true;
        return false;
    }
}
