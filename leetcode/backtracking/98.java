class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(isValidBST(root.left) && (prev == null || root.val > prev.val)) {
            //int p = (prev == null) ? 0 : prev.val;
          //  System.out.println("root: "+root.val+"prev: "+p);
            prev = root;
            return isValidBST(root.right);
        }
        
        return false;
    }
}