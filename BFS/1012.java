import java.util.*;
import java.io.*;

class two {
	int x;
	int y;

	two(int a, int b) {
		x = a;
		y = b;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		FastReader fr = new FastReader();
		int T = fr.nextInt();
		int x, y;
	String answer = "";

		Queue<two> q = new LinkedList<>();
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int count = 0;
		for (int t = 0; t < T; t++) {
			count = 0;
			int M = fr.nextInt();// 가로길이
			int N = fr.nextInt();// 세로길이
			int K = fr.nextInt();
			int map[][] = new int[N][M];
			for (int w = 0; w < K; w++) {
				y = fr.nextInt();
				x = fr.nextInt();
				map[x][y]++;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						count++;

						q.add(new two(i, j));
						map[i][j] = 0;
						while (!q.isEmpty()) {// 큐를 사용한 bfs
							two temp = q.poll();

						
							for (int k = 0; k < 4; k++) {
								x = dx[k] + temp.x;
								y = dy[k] + temp.y;
								if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || map[x][y] == 0)
									continue;
								q.add(new two(x, y));
map[x][y]  =0 ;
							}
						}

					}
				}
			}
			answer+= count;
			answer+="\n";
			
		}
		System.out.println(answer);
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