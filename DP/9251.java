import java.util.*;
import java.io.*;

class Main{
    static int answer = 0;
    static StringTokenizer st ;
    static int[] arr;
    static int count= 0 ;
    public static void main(String[] argv) throws IOException{
        StringWriter sw  =new StringWriter ();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
  nextLine(br.readLine());
  
   String a = st.nextToken();
   nextLine(br.readLine());
   String b = st.nextToken();
   int alen = a.length();
   int blen = b.length();
    int dp[][] =new int[alen+1][blen+1];
   //초기값이 0이므로 0으로 초기화 생략. 
   
    for(int i = 1 ;i<=alen; i++) {
    	for(int j = 1; j<=blen; j++){
    		//현재 문자같으면.
    		if( a.charAt(i-1) == b.charAt(j-1)) {
    			dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]+1);
    		}else {
    			dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
    		}
    	}
    }
    System.out.println(dp[alen][blen]);

    }
    public static void dfs(int depth, int sum,int target) {
    	if(depth > 0 && sum == target ) count++;
    	if(depth >= arr.length) {
    	return;	
    	}
    	for(int i = depth; i< arr.length; i++) {
    		dfs(i+1, sum+arr[i] , target);
    	}
    }
    public static void pl() {
    for(int i =0 ;i < arr.length ;i++)
    {
    System.out.print(arr[i] + " ");
    }System.out.println();
    }
    public static void nextLine(String br) {
    		st = new StringTokenizer(br);
    }
    public static int nextInt() {
    	if(st == null)throw new NullPointerException("st가 비어있음");
    	return Integer.parseInt(st.nextToken());
    }
  
}