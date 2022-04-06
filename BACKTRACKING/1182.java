import java.util.*;
import java.io.*;

class Main{
    static int answer = 0;
    static StringTokenizer st ;
    static int[] arr;
    static boolean visit[];
    static int count= 0 ;
    public static void main(String[] argv) throws IOException{
        StringWriter sw  =new StringWriter ();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
  nextLine(br.readLine());
  
   int n = Integer.parseInt( st.nextToken());
   int s = Integer.parseInt( st.nextToken());
    arr = new int[n];
    visit = new boolean[n];
    
   nextLine(br.readLine());
   
   for(int i =0  ;i< n; i++) {
	arr[i] = nextInt();
   }
   if(n == 1) {
	   if(arr[0] == s)count++;
   }else {
	   dfs(0, 0, s);
   }
   
   System.out.println(count);

    }
    public static void dfs(int depth, int sum,int target) {
    	if(depth > 0 && sum == target ) count++;
    	if(depth >= arr.length) {
    	return;	
    	}
    	for(int i = depth; i< arr.length; i++) {
    		if(visit[i])continue;
//pl();
    		visit[i] = true;
    		dfs(i+1, sum+arr[i] , target);
    		visit[i] = false;
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