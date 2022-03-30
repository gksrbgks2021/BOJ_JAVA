import java.util.*;
import java.io.*;

//Bottom up approch.

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int N = fr.nextInt();
		int K = fr.nextInt();
		int weight[] = new int[N];
		int value[] = new int[N];
		for(int i = 0 ;i < N;i++) {
			weight[i] = fr.nextInt();
			value[i] = fr.nextInt();
			
		}
		//최대 무게 0 부터  K 까지 iterate.
		int dp[][]= new int [N+1][K+1];
		
		for(int i = 1; i <= N; i++) {//i는 물건의 수를 뜻.
			for(int j = 1; j<=K ; j++) {//j는 쵀대 용량을 뜻함. 
				if(weight[i-1] <=j ) {
					dp[i][j] = Math.max( dp[i-1][j] , dp[i-1][j - weight[i-1] ]
							+value[i-1]);
				}
				else
					dp[i][j] = dp[i-1][j];
			}
		}
	System.out.println(dp[N][K]);
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
