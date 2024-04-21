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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
         if(root == NULL) return vector<vector<int>>();
        
        queue<TreeNode*> q ;
        q.push(root);
        vector<vector<int>> res;
        bool leftToRight = true;

        while(!q.empty()){
            int sizer = q.size();
            vector<int> vec(sizer);

            for(int i=0;i<sizer;i++){
                TreeNode* temp = q.front();
                q.pop();

                int index = (leftToRight)?i:sizer-1-i;                
                vec[index] = temp->val;

                if(temp->left!=NULL) q.push(temp->left);
                if(temp->right!=NULL) q.push(temp->right);
            }
            res.push_back(vec);
            leftToRight = !(leftToRight);
        
          
        }
        return res;
    }
};