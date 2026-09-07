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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int p = preorder[0];
        int id = 0;
        for(int i=0;i<inorder.length;i++){
            if(p==inorder[i]){
                id=i;
            }
        }
        TreeNode root = new TreeNode(p);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,id+1),Arrays.copyOfRange(inorder,0,id));
        root.right = buildTree(Arrays.copyOfRange(preorder,id+1,preorder.length),Arrays.copyOfRange(inorder,id+1,inorder.length));
        return root;
    }
}
