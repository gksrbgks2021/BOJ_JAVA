import java.util.*;
import java.io.*;

public class Main {
	static int gap = (int) 1e8;
static boolean[]visit;
static int[][] map;
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		 map = new int[n][n];
visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = fr.nextInt();
			}
		}
		dfs(0,0);
		System.out.println(gap);
	}

	public static void dfs(int index, int a) {
		if (a == map.length / 2) {
			int a1 = 0;
			int a2 = 0;

			for (int i = 0; i < map.length - 1; i++) {
				for (int j = i + 1; j < map.length; j++) {
					// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
					if (visit[i] == true && visit[j] == true) {
						a1 += map[i][j];
						a1 += map[j][i];
					}
					// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
					else if (visit[i] == false && visit[j] == false) {
						a2 += map[i][j];
						a2 += map[j][i];
					}
				}
			}
			gap = Math.min(gap,  Math.abs(a2-a1));
			if(gap == 0 ) {
				System.out.println(0);
				System.exit(0);
			}
			return;
		}

		for (int i = index; i < map.length; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			dfs(i + 1,a+1);
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
