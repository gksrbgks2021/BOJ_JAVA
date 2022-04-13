class Solution {
    public int lengthOfLIS(int[] nums) {
        //O(N^2)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for(int i =1 ;i < nums.length; i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int getindex = BinarySearch(list, nums[i]);
                list.set(getindex, nums[i]);
            }
        }
        return list.size();
    }//이진탐색을 하고 거길 넣어준다. 
    public int BinarySearch(List<Integer> list, int num){
        int l = 0 ;
        int r = list.size()-1;
        while(l < r){
            int pi = l+ (r-l)/2;
            if(list.get(pi)== num ) {
                return pi;
            }else if(list.get(pi) < num){
                l = pi+1;
            }else{
                r = pi;   
            }
        }
        return l;
    }
}