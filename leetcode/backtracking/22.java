class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
  helper(combinations, new char[n*2], 0, 0);
        
        return combinations;
    }

    public void helper (List<String> com , char[] arr, int depth,int count){
        if(depth == arr.length){
            //끝에 도달했으면 검사를 하고 반환. ㅇ
         if(valid(arr))
             com.add( toString(arr) );
            return ;
        }
        
        
        arr[depth] = '(';
        count++;
        helper(com, arr, depth+1,count);
        count--;
        
        if(count >0)
        {
            arr[depth] = ')';
            count--;
        helper(com, arr, depth+1,count);
            count++;
        }
        
        
    }
    public String toString(char[] s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < s.length; i++){
            sb.append(s[i]);
        }
        return sb.toString();
    }
    public boolean valid(char[] arr){
        int count=0;
        
        for(int i = 0 ;i < arr.length ;i++){
                if(arr[i] =='(')
                    count++;
            else count--;
            if(count < 0)return false;
        }
        return count == 0 ;
    }
   
}