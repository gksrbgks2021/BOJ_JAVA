class Solution {
    public int rob(int[] nums) {
        //2번의 경우를 나눈다.
        //0번쨰를 털고, 마지막을 안턴다. 
    //0번째 안 털고, 마지막 턴다.
        int dp[] = new int[nums.length+1];
        int reverse_dp[] = new int[nums.length+1];
        
        if(nums.length == 1 )return nums[0];
        
        int len = nums.length ;
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<len;i++){
            dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
        }
        
            reverse_dp[0] = 0;
        reverse_dp[1] = 0;//출발은 1부터.
        reverse_dp[2] = nums[1];//출발은 1부터.
    
        for(int i = 3; i<= len; i++){
            reverse_dp[i] = Math.max(nums[i-1]+reverse_dp[i-2], reverse_dp[i-1]);
        }
        
        return Math.max(dp[len-1], reverse_dp[len]);
    }
}