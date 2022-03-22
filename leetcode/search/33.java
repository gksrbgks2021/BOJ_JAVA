class Solution {
    public int search(int[] nums, int target) {
    
        int l=0 , r=nums.length-1; 
    
        while(l <=r ){
            int a = nums[l];
            int b = nums[r];
             int pi =l+ (r-l)/2;
            int c = nums[pi];
            if(target == c)return pi;
            
        if(a <= c){//오름차순일때.
                if(target < c && target >= a)              r = pi-1;
                 else l = pi+1;
        }
        else{//역방향일때. 
              if(target >c && target<=b)  l = pi+1;
            else    r = pi-1;
        }
        }
    return -1;
    }
}