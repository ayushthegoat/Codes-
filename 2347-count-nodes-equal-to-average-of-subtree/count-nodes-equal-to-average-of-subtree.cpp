/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    pair<int, int> postOrder(TreeNode* root, int& result){
        if(root == nullptr) return {0, 0};

        auto left = postOrder(root->left, result);
        auto right = postOrder(root->right, result);

        int sum = left.first + root->val + right.first;
        int count = left.second + 1 + right.second;

        if(sum / count == root->val)result++;
        return {sum , count};
    }

    int averageOfSubtree(TreeNode* root) {
        int result = 0;
        postOrder(root, result);
        return result;
    }
};