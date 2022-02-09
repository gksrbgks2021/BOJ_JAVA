
import java.util.*;

import java.io.*;

public class Main {
	public static int[] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
    int m = fr.nextInt();
    int num[] = new int[n];
    map =new int[9];
    visit = new boolean[n];
    for(int i =0 ; i< n; i++){
      num[i] = fr.nextInt();
    }
   Arrays.sort(num);
    helper(n, m, 0, num);
    System.out.println(sb);
	}

	public static void helper(int a, int b,int depth,int num[]) {
		if (b == depth) {
			for(int i = 0 ;i < b; i++) {
				sb.append(map[i] +" ");
			}
			sb.append('\n');
			return ;
		}
		
		for (int i = 0; i < a; i++) {
			if(visit[i])continue;
			visit[i] = true;
			map[depth] = num[i];
			helper(a, b, depth+1 , num);
			visit[i] =false;
		}
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