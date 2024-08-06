public class Solution {
   
    public IList<IList<string>> GroupAnagrams(string[] strs) {
    
        Dictionary<string, IList<string>> anagramGroups = new Dictionary<string, IList<string>>();

        foreach (var str in strs)
        {
            // Sort the characters to create a key for anagrams
            var sortedStr = new string(str.OrderBy(c => c).ToArray());

            if (!anagramGroups.ContainsKey(sortedStr))
            {
                anagramGroups[sortedStr] = new List<string>();
            }
            anagramGroups[sortedStr].Add(str);
        }

        // Convert dictionary values to list and sort each group
        var result = anagramGroups.Values.ToList();

        // Sort the result to ensure consistent ordering
        result.Sort((x, y) => x[0].CompareTo(y[0]));

        return result;
    }
}