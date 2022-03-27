class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    HashMap<Integer, Integer> cache = new HashMap();//중복 방지 캐싱.
    
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+i);//빈도수 * val 매핑을 합니다. 
            if(max < i)max = i;
        }   
        
        return helper(max);
    }
    public int helper(int num){
        if(num == 0)return 0;
        if(num == 1)return map.getOrDefault(1, 0);
        
        if(cache.containsKey(num))return cache.get(num);
        
        int gain = helper(num-1);
        int cur = map.getOrDefault(num, 0) + helper(num-2) ; //현재꺼 선택했을때. 
        
        cache.put(num, Math.max(gain, cur));
        
       return cache.get(num); 
    }
}