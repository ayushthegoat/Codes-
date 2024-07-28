public class Solution {
    public int[] SortJumbled(int[] mapping, int[] nums) {
        var transformedWithOriginals = new List<(int transformed, int original)>();

        foreach (int num in nums)
        {
            string s = num.ToString();
            string newNum = "";

            foreach (char c in s)
            {
                int digit = c - '0'; // Convert char to int
                newNum += mapping[digit];
            }

            // Remove leading zeros
            int ctr = 0;
            while (ctr < newNum.Length && newNum[ctr] == '0')
            {
                ctr++;
            }

            newNum = ctr == newNum.Length ? "0" : newNum.Substring(ctr);
            int transformed = int.Parse(newNum);

            // Add the transformed number and original number to the list
            transformedWithOriginals.Add((transformed, num));
        }

        // Sort by the transformed values
        var sorted = transformedWithOriginals
            .OrderBy(pair => pair.transformed)
            .Select(pair => pair.original)
            .ToArray();

        return sorted;
     }
}