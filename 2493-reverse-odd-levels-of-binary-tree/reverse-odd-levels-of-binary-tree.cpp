/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if (!root) return nullptr;

        vector<int> values;
        queue<TreeNode*> q;
        q.push(root);
        int level = 0;

        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> temper ;

            for (int i = 0; i < levelSize; i++) {
                TreeNode* node = q.front();
                q.pop();
                if(level%2!=0)node->val = values[levelSize-1-i];

                if (node->left) {
                    q.push(node->left);
                    temper.push_back(node->left->val);
                }
                if (node->right){
                    q.push(node->right);
                    temper.push_back(node->right->val);
                }
            }

           level++;
            values = temper;
           
        }

        return root;
    }
};