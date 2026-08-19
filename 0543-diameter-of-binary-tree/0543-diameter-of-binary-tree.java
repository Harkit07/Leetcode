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
    static class Info{
        int daim;
        int ht;
        public Info(int daim, int ht){
            this.daim=daim;
            this.ht=ht;
        }
    }
    public Info diameter(TreeNode root){
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int daim = Math.max(Math.max(leftInfo.daim, rightInfo.daim), leftInfo.ht+rightInfo.ht);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new Info(daim, ht);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info result = diameter(root);
        return result.daim;
    }
}