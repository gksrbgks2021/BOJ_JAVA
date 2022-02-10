
import java.util.*;
import java.io.*;

public class Main {
	public static int[] map;
	public static boolean visit[] = new boolean[9];
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int a = fr.nextInt();// 총 개수
		int b = fr.nextInt();// 뽑는 개수
		int temp = a;
		map = new int[b];
		
		helper(a,b,0);
	}

	public static void helper(int a, int b,int depth) {
		if (b == depth) {
			for(int i : map) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < a; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			map[depth] = i+1;
			helper( a, b ,depth+1  );
			visit[i] = false;
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