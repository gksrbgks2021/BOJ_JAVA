import java.util.*;
import java.io.*;

//Bottom up approch.

public class Main {

	static int cache[][] ;
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int[][] dp = new int[n][n];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j<= i ;j++) {
				dp[i][j] = fr.nextInt();
			}
		}
		cache = new int[n][n];
		
		int max = -1;
	
		int gain = dp(dp, 0, 0, 0);
		
	System.out.println(gain);	
	}
	public static int dp(int[][] arr, int depth,int i, int j) {
		//왼쪽 ,. 오른쪽.ㅇ
		if(depth == arr.length-1) {//끝에 도달.
			cache[i][j] = arr[i][j];
		}
		
		else if(cache[i][j] == 0) {
			int left = dp(arr, depth+1, i+1, j);
			int right = dp(arr, depth+1, i+1, j+1);
			cache[i][j] = Math.max(left, right) + arr[i][j];
		}
			return cache[i][j];
	}

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
