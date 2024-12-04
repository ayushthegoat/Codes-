public class Solution {
    public string AddSpaces(string s, int[] spaces) {
       StringBuilder sb = new StringBuilder();
       HashSet<int> spaceSet = new HashSet<int>(spaces);
       
       for(int i = 0; i < s.Length; i++) {
         if (spaceSet.Contains(i)) {
            sb.Append(" ");
        }
        sb.Append(s[i]);
       }
       return sb.ToString();
    }
}