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
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;
        public Info( boolean isBST, int size, int min, int max, int sum){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }

    static int maxSum = 0;

    public Info largestBST(TreeNode root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int sum = leftInfo.sum+rightInfo.sum+root.val;
        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));

        if(root.val<=leftInfo.max || root.val>=rightInfo.min){
            return new Info(false, size, min, max, sum);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxSum = Math.max(maxSum, sum);
            return new Info(true, size, min, max, sum);
        }
        return new Info(false, size, min, max, sum);
    }

    public int maxSumBST(TreeNode root) {
        maxSum=0;
        largestBST(root);
        return maxSum;
    }
}