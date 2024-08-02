public class Solution {
    public int CountSeniors(string[] details) {
       return details
        .Select(item => Convert.ToInt32(item.Substring(11, 2)))
        .Count(age => age > 60);
    }
}