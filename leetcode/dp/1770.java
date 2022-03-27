class Solution {
    //top down 
    int[] num;
    int [] mul;
    int [][]memo ;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        num = nums;
        mul = multipliers;
        memo = new int[multipliers.length][multipliers.length];
        
      	return topdowndp( 0, 0, nums.length - 1);
    }
    
   	private int topdowndp( int i, int start, int end) {
		if (i == mul.length) {
			return 0;
		}
        
		if (memo[i][start] != 0) {
			return memo[i][start];
		}
        
		int resStart = mul[i] * num[start] + topdowndp(i + 1, start + 1, end);
		int resEnd = mul[i] * num[end] + topdowndp( i + 1, start, end - 1);
        
		memo[i][start] = Math.max(resStart, resEnd);
		return memo[i][start];
        
	}
}


