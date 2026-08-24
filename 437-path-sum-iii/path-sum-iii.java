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

    public int dfs(TreeNode root, int targetSum, HashMap<Long,Integer> map, Long prefixSum)
    {
        if(root == null)
        {
            return 0;
        }

        prefixSum += root.val;
        int sum = 0;

        if(map.containsKey(prefixSum - targetSum))
        {
            sum += map.get(prefixSum - targetSum);
        }

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        int left = dfs(root.left, targetSum, map, prefixSum);
        int right = dfs(root.right, targetSum, map, prefixSum);

        map.put(prefixSum, map.get(prefixSum) - 1);
        if(map.get(prefixSum) == 0)
        {
            map.remove(prefixSum);
        }

        return left + right + sum;

    }
    public int pathSum(TreeNode root, int targetSum) {
        
        HashMap<Long, Integer> map = new HashMap<>();

        map.put(0L, 1);
        int total = dfs(root, targetSum, map, 0L);

        return total;
    }
}