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

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns [sum, count]
    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        // Get left subtree information
        int[] left = dfs(node.left);

        // Get right subtree information
        int[] right = dfs(node.right);

        // Calculate current subtree sum and count
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        // Calculate average
        int average = sum / count;

        // Check condition
        if (node.val == average) {
            ans++;
        }

        return new int[]{sum, count};
    }
}