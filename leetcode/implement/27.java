class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int input = 0;
        int count = 0 ;
      while(index < nums.length){
          if(nums[index] == val)index++;
          else{
              nums[input++] =nums[index++];
              count++;
          }
      }
        return count;
    }
}