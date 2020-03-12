/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if (root == NULL) return true;
        int ans = height(root);
        if (ans < 0) return false;
        return true;
    }

    int height(TreeNode* node) {
        if (node->left == NULL && node->right == NULL) return 1;

        int lh = 0;
        int rh = 0;
        if (node->left != NULL) lh = height(node->left);
        if (lh < 0) return -1;
        if (node->right != NULL) rh = height(node->right);
        if (rh < 0) return -1;

        if (lh < rh) {
            swap(lh , rh);
        }

        if (lh - rh >= 2) return -1;
        return lh + 1;
    }
};