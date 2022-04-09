class Solution {
    List<List<Integer>>l = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if( root == null)return l ;
        List<Integer> li = new ArrayList<>();
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                li.add(root.val);
                l.add(li);
            }
            
            return l;
        }
        
        li.add(root.val);
        
        helper(root.left, targetSum- root.val, li);
        helper(root.right, targetSum - root.val,li);
        return l;
    
    }
    public void helper(TreeNode root, int targetSum, List<Integer> list){
        if(root== null)return;
        if(root.left== null && root.right == null && targetSum - root.val==0){
            list.add(root.val);

            l.add(new ArrayList(list)) ;
            list.remove(list.size()-1); 
            return;
        }
        list.add(root.val);
    helper(root.left , targetSum - root.val, list );
        helper(root.right , targetSum - root.val, list );
        list.remove(list.size()-1);
    }
}