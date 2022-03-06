class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);//오름차순 정렬
        List<List<Integer>> list = new ArrayList<>();
        
        int l, r;
        for(int i = 0 ; i< nums.length && nums[i] <= 0 ; i++){
            while(i>0 && nums[i] == nums[i-1] &&i+1<nums.length)i++;//다음꺼가 아니라 이전꺼를 비교해줘야한다. 
            
            l = i+1; 
            r = nums.length-1; 
            while(l < r ){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum > 0)
                    r--;
                    else if(sum < 0)
                        l++;
                        else//when sum == 0 
                        {
                         list.add(Arrays.asList(nums[i],nums[l],nums[r] ))   ;
                            l++;
                            r--;
                            while(l < r && nums[l] == nums[l-1]){
                                l++;//반복을 없앱니다. 
                            }
                        }
            }
        }    
        
        return list;
    }
    
}
