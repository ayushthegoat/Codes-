public class Solution {
   
    public IList<IList<string>> GroupAnagrams(string[] strs) {
    
        Dictionary<string, IList<string>> anagramGroups = new Dictionary<string, IList<string>>();

        foreach (var str in strs)
        {
           
            var sortedStr = new string(str.OrderBy(c => c).ToArray());

            if (!anagramGroups.ContainsKey(sortedStr))
            {
                anagramGroups[sortedStr] = new List<string>();
            }
            anagramGroups[sortedStr].Add(str);
        }

        // Convert dictionary values to list and sort each group
        var result = anagramGroups.Values.ToList();

       

        return result;
    }
}