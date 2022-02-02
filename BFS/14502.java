import java.util.*;
import java.io.*;

class Wall {
	int x;
	int y;

	Wall(int a, int b) {
		x = a;
		y = b;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int N, M;
		// 0 은 빈 칸 1은 벽 2 바이러스
		N = fr.nextInt();
		M = fr.nextInt();
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = fr.nextInt();

			}
		}
		int answer = -1;
		for (int i = 0; i < N * M - 2; i++) {
			if (map[i / M][i % M] != 0)
				continue;// 벽 못 세우는 경우
			for (int j = i + 1; j < (N * M) - 1; j++) {
				if (map[j / M][j % M] != 0)
					continue;// 벽 못 세우는 경우
				for (int k = j + 1; k < N * M; k++) {
					if (map[k / M][k % M] != 0)
						continue;// 벽 못 세우는 경우
					map[i / M][i % M] = 1;
					map[j / M][j % M] = 1;
					map[k / M][k % M] = 1; // 벽을 세우고 안전 영역 구하고 다시 벽을 허뭄.

					answer = Math.max(answer, bfs(map));

					map[i / M][i % M] = 0;
					map[j / M][j % M] = 0;
					map[k / M][k % M] = 0;
				}
			}
		}
		System.out.println(answer);
	}

	public static int bfs(int[][] map) {
		int ans = 0;
		boolean visit[][] = new boolean[map.length][map[0].length];
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		Queue<Wall> q = new LinkedList<>();
boolean never = false;
int count = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				
				if (!visit[i][j] && map[i][j] == 0) {
					never = false;
					visit[i][j] = true;
					q.add(new Wall(i, j));
					count = 1;
					while (!q.isEmpty()) {
						Wall w = q.poll();
						for(int k = 0 ; k < 4; k++) {
							int nx = w.x+dx[k];
							int ny = w.y+dy[k];
							if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visit[nx][ny] || map[nx][ny]==1 )continue;
							if(map[nx][ny] == 2)never = true;
							
							visit[nx][ny] = true;
							q.add(new Wall(nx,ny));
									count++;
						}
					}
					if(!never) ans +=count; //바이러스 없을때만, 최신화해준다. 
				}
				
			}
		}
		return ans;
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