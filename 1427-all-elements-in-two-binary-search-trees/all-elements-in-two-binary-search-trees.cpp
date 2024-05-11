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
private:

    void merger(vector<int>&v1 ,vector<int>&v2, vector<int>&res){
         int i=0;
         int j=0;
         while(i<v1.size() && j<v2.size()){
            if(v1[i]<v2[j]){
                res.push_back(v1[i]);
                i++;
            }else{
                res.push_back(v2[j]);
                j++;
            }
         }

            while(i<v1.size())res.push_back(v1[i++]);
            while(j<v2.size())res.push_back(v2[j++]);
         }
        
    
    void inorder(TreeNode* root, vector<int>&v){
        if(root==nullptr)return ;

        inorder(root->left, v);
        v.push_back(root->val);
        inorder(root->right, v);
    }
     
public:
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> t1;
        vector<int> t2;
        vector<int> res;
        inorder(root1, t1);
        inorder(root2, t2);
        merger(t1, t2 ,res);
        return res;
    }
};