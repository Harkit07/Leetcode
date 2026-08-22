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
    static StringBuilder count=new StringBuilder();
    static int sum=0;

    public void countSum(TreeNode root){
         if(root==null){
            return;
        }
        count.append(root.val);
        if(root.left==null && root.right==null){
            int num = Integer.parseInt(count.toString());
            sum+=num;
        }
        countSum(root.left);
        countSum(root.right);
        count.deleteCharAt(count.length()-1);
    }

    public int sumNumbers(TreeNode root) {
        sum=0;
        count=new StringBuilder("");
        countSum(root);
        return sum;
    }
}