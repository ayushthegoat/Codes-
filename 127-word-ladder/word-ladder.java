class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list to a set for quick access
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in the word list, return 0
        }

        // Queue for BFS that stores pairs (current word, current transformation length)
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // Perform BFS
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int steps = current.getValue();

            // Check if the current word is the endWord
            if (word.equals(endWord)) {
                return steps;
            }

            // Try changing each letter of the current word
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                char originalChar = wordArray[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);

                    // If the new word is in the set, add it to the queue and remove from the set
                    if (wordSet.contains(newWord)) {
                        queue.add(new Pair<>(newWord, steps + 1));
                        wordSet.remove(newWord);
                    }
                }

                // Restore the original character
                wordArray[i] = originalChar;
            }
        }

        return 0; // If no transformation is found, return 0
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}