public class Solution {
    private int n;
    private int max;

    private void Solve(int index, int[] score, string[] words, int curr, int[] hash) {
         max = Math.Max(max, curr);
        if (index >= n)
        {
            return;
        }

        // can we even take the word
        int j = 0;
        int tempScore = 0;
        int[] tempFreq = new int[hash.Length];
        Array.Copy(hash, tempFreq, hash.Length);
        while (j < words[index].Length)
        {
            char ch = words[index][j];

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
            {
                break;
            }
            j++;
        }

        if (j == words[index].Length)
        {
            // take the word
            Solve(index + 1, score, words, curr + tempScore, tempFreq);
        }

        // not take case
        Solve(index + 1, score, words, curr, hash);
    }

    public int MaxScoreWords(string[] words, char[] letters, int[] score) {
        int[] hash = new int[26];

        foreach(char ch in letters) {
            hash[ch - 'a']++;
        }
        max = int.MinValue;
        n = words.Length;
        Solve(0, score, words, 0, hash);
        return max;

    }
}