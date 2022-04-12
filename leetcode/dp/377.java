class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
    //정렬을 안 해도 된다. 
        int dp[] =new int[target+1];
        dp[0] = 1;
        for(int num = 1 ;num <=target; num++){
        for(int i = 0 ;i< nums.length ;i++){
            if( num - nums[i] < 0)continue;
            dp[num] += dp[num-nums[i]];
        }    
        }
        return dp[target];
    }
}