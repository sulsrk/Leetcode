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
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        down(root, max);
        return max[0];
    }

    private int down(TreeNode root, int[] max){
        if (root == null) return 0;
        
        int left = down(root.left, max);
        int right = down(root.right, max);
        int init = root.val;

        if (left > 0 || right > 0){
            init += Math.max(left, right);
            root.val += Math.max(left, 0);
            root.val += Math.max(right, 0);
        }

        max[0] = Math.max(root.val, max[0]);

        return init;
    }

    // private int findMax(TreeNode root){
        // Less memory solution
    //     if (root == null) return Integer.MIN_VALUE;

    //     return Math.max(Math.max(findMax(root.left), findMax(root.right)), root.val);
    // }
}
