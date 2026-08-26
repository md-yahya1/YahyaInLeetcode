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
    public int maxLevelSum(TreeNode root) {
        
        int maxLevel = 0;
        int level = 1;
        int maxSum = Integer.MIN_VALUE;

        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size; i++)
            {
                TreeNode top = q.remove();
                sum += top.val;

                if(top.left != null)
                {
                    q.offer(top.left);
                }
                if(top.right != null)
                {
                    q.offer(top.right);
                }  

            }

            if(maxSum < sum)
                {
                    maxLevel = level;
                    maxSum = sum;
                }
            level++;
        }

        return maxLevel;
    }
}