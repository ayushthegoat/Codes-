public class Solution {
    public int CountSeniors(string[] details) {
        int counter = 0;
        foreach(var item in details) {
            string str = item;
            int age = Convert.ToInt32(str.Substring(11, 2));
            if(age > 60) counter++;
        }
        return counter;
    }
}