import java.util.*;
import java.io.*;

//Bottom up approch.

public class Main {

	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int[][] dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = fr.nextInt();
			}
		}
		// 집을 칠하는 비용의 최소값.
		
		for(int i =1 ; i< n; i++) {
			dp[i][Red] += Math.min(dp[i-1][Green],dp[i-1][Blue]);
			dp[i][Blue] += Math.min(dp[i-1][Green],dp[i-1][Red]);
			dp[i][Green] += Math.min(dp[i-1][Red],dp[i-1][Blue]);
		}
		
		System.out.println(Math.min(dp[n-1][Red], Math.min(dp[n-1][Blue], dp[n-1][Green])));
		
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
