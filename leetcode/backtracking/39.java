class Solution {
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return list;
    }
    public void helper(int[] arr, int target, int index, List<Integer> dude){
        if(target<0)return;
        else if(target==0){
            list.add(new ArrayList(dude));
            return;
        }
        
        
        for(int i = index ;i < arr.length ; i++){
            dude.add(arr[i]);
            helper(arr, target- arr[i], i, dude);
                dude.remove(dude.size()-1);//remove last element
        }
    }
}