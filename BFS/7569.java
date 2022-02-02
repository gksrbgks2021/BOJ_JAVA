import java.util.*;
import java.io.*;

class Block {
	int x;
	int y;
	int z;

	Block(int a, int b, int c) {
		x = a;
		y = b;
		z = c;
	}
}

public class Main {
	static boolean[][][] visit;
	static int rape = 0;

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int M, N, H;

		M = fr.nextInt();// 가로 칸의수
		N = fr.nextInt();// 세로 칸의 수
		H = fr.nextInt();// 높이
		// 익은 토마토 1 안익은 토마토 0
		// 모든 토마토가 익어있으면 0 출력. 토마토가 모두 익지는 못하면, -1

		boolean flag = true;
		int map[][][] = new int[N][M][H];
		visit = new boolean[N][M][H];
		Queue<Block> q = new LinkedList<>();
		for (int k = 0; k < H; k++) {// 높이 만큼.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j][k] = fr.nextInt();
					if (map[i][j][k] == 1) {// 익었으면 방문처리
						visit[i][j][k] = true; // 방문
						q.add(new Block(i, j, k));
					}
					if (map[i][j][k] == 0) {
						flag = false;
						rape++;
					}
				}
			}
		}
		if (flag) {// 모든 토마토가 익어있으면? --> 안익은 토마토가 없으면
			System.out.println(0);
		} else {
			int answer = bfs(q, map);
			if(rape > 0)System.out.println(-1);
			else System.out.println(answer);
		}
	}

	public static int bfs(Queue<Block> q, int[][][] map) {
		int days = 0;
		int dx[] = { 0, 0, 1, -1, 0, 0 };// 상하 앞뒤 좌우
		int dy[] = { 0, 0, 0, 0, 1, -1 };
		int dz[] = { 1, -1, 0, 0, 0, 0 };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Block tomato = q.poll(); // 큐에 토마토 꺼냄.

				for (int j = 0; j < 6; j++) {
					int nx = dx[j]+tomato.x;
					int ny = dy[j]+tomato.y;
					int nz = dz[j]+tomato.z;
					if(nx < 0 || nx >=map.length || ny < 0 || ny >=map[0].length 
							|| nz<0 || nz >= map[0][0].length ||visit[nx][ny][nz] 
									|| map[nx][ny][nz] != 0)continue; //방문 안했고 안익은것만 집어넣어!~
					map[nx][ny][nz] = 1;
					visit[nx][ny][nz] = true;
					rape--;
					q.add(new Block(nx,ny,nz));
				}
			}
			days++;
			if(rape <= 0 )break;
		}
		return days;
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