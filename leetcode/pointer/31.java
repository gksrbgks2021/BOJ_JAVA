class Solution {
    public void nextPermutation(int[] nums) {
//맨 뒤부터 리버스 순회.
        //오름차순이면 패스. 숫자가 작으면 pivot.
        //pivot이랑 가장 오른쪽 successor이랑 바꿈.
        //바꿨으면, 리버스
        if(nums.length ==1)return;
boolean flag=true;
        for(int i = nums.length-1 ; i>=1 ;i--){
            if(nums[i-1] <nums[i]){
                flag = false;
                findnextsuccecor(nums, i-1);
                reverse(nums,i,nums.length-1);
                break;
            }
        }
        if(flag){
             swap(nums,0,nums.length-1);
            reverse(nums,1,nums.length-2);
        }
        
    }
    public void findnextsuccecor(int a[], int pivot_i){
        int far=pivot_i;
        
        for(int i = pivot_i+1; i<a.length ;i++){
            if(a[i]> a[pivot_i])
                far = i;
        }
        if(pivot_i != far)
            swap(a, far, pivot_i);
    }
    public void reverse(int [] a, int start, int end){
        while(start < end){
            swap(a, start++, end--);
        }
    }
    public void swap(int[] a, int b , int c){
        a[b] ^= a[c];
        a[c] ^= a[b];
        a[b] ^= a[c];
    }
}