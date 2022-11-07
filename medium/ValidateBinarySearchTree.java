public class ValidateBinarySearchTree {

  // https://leetcode.com/problems/validate-binary-search-tree/description/

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.val < min || root.val > max) {
      return false;
    }
    return helper(root.left, min, root.val - 1L)
        && helper(root.right, root.val + 1L, max);
  }
}
