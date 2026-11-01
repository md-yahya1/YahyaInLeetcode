/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        
        int[] ans = new int[1];
        int[] count = new int[1];
        ans[0] = 0;
        count[0] = 0;
        
        inorder(root, k, count, ans);
        return ans[0];
    }
     public void inorder(TreeNode root, int k, int[] count, int[] ans) {
        if (root == null)
            return;

        inorder(root.left, k, count, ans);

        count[0]++;
        if (count[0] == k) {
            ans[0] = root.val;
            return;
        }

        inorder(root.right, k, count, ans);
    }
}