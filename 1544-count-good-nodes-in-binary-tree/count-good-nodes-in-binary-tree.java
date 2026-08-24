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

    public void dfs(TreeNode root, int maxValue, int[] count)
    {
        if(root == null)
        {
            return;
        }

        if(root.val >= maxValue)
        {
            count[0]++;
        }

        maxValue = Math.max(root.val, maxValue);

        dfs(root.left, maxValue, count);
        dfs(root.right, maxValue,  count);

    }
    public int goodNodes(TreeNode root) {
        
        int count[] = new int[1];
        dfs(root, Integer.MIN_VALUE, count);

        return count[0];
    }
}