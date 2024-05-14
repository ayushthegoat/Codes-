class Trie {
public:
    struct trieNode {
        bool isEndOfWord;
        trieNode* children[26];
    };
    trieNode* getNode() {
        trieNode* newNode = new trieNode();
        newNode->isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            newNode->children[i] = nullptr;
        }
        return newNode;
    }
    trieNode* root;
    Trie() { root = getNode(); }

    void insert(string word) {
        trieNode* crawler = root;
        for (const char& ch : word) {
            if (crawler->children[ch - 'a'] == nullptr) {
                crawler->children[ch - 'a'] = getNode();
            }
            crawler = crawler->children[ch - 'a'];
        }
        crawler->isEndOfWord = true;
    }

    bool search(string word) {
        trieNode* crawler = root;
        for (const char& ch : word) {
            if (crawler->children[ch - 'a'] == nullptr) {
                return false;
            }
            crawler = crawler->children[ch - 'a'];
        }
        if (crawler != nullptr && crawler->isEndOfWord == true) {
            return true;
        }
        return false;
    }

    bool startsWith(string prefix) {
        trieNode* crawler = root;
        int i;
        for (i = 0; i < prefix.size(); i++) {
            char ch = prefix[i];
            int idx = ch - 'a';

            if (crawler->children[idx] == nullptr) {
                return false;
            }

            crawler = crawler->children[idx];
        }
    
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */