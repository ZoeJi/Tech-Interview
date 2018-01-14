/**
 * @Author: Qianying Ji
 *
 * The following code is my solution to the classic Lowest Common Ancestor(LCA) problem with thoughts and explanation.
 * Problem description: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //extend the definition of return of lowestCommonAncestor:
    //left != null && right != null, return root (LCA)
    //left != null && right == null, return left (the p/q or LCA in left subtree)
    //left == null && right != null, return right (the p/q or LCA in the right subtree)
    //left == null && right == null, return null ()
    
    //Since we don't have parent pointer, we need to pass information up to parent node, so we can use recursion
    //But what kind of information we need to pass up?
    //Let's analyize what information we need to get from left and right:
    //  if root is LCA - one p/q in left subtree && one p/q in right subtree
    //                 - root == p || root == q;
    //                 - return LCA
    //  if root is not LCA - LCA in left subtree || LCA in the right subtree || LCA NOT in this tree
    //  Definition of returns: LCA, p, q
    //Pass up whatever this recursion encounters: LCA, p, q !!!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root; // if encounter p or q, return it; use recursion to find p & q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root; // found LCA
        if(left != null && right == null) return left; // 1.LCA in left subtree || 2. only one node in left subtree
        return right;
    }
}
