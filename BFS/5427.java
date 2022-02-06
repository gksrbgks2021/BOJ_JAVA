package temp;

import java.util.*;
import java.io.*;

class Pair {
	int x;
	int y;
	int index;

	Pair(int a, int b) {
		x = a;
		y = b;
	}

	Pair(int a, int b, int c) {
		x = a;
		y = b;
		index = c;
	}

	int getIndex() {
		return this.index;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int w, h;
		int T = fr.nextInt();
		String answer = "";

		while (T-- > 0) {
			w = fr.nextInt();
			h = fr.nextInt();
			int[][] map = new int[h][w];
			int time = 0;
			boolean visit[] = new boolean[1000];
			boolean finish = false;
			boolean isarrival = false;
			int dx[] = { 1, -1, 0, 0 };
			int dy[] = { 0, 0, 1, -1 };
			int size;
			Queue<Pair> fire = new LinkedList<>(); // 불의 위치 집어넣는다.
			Queue<Pair> position = new LinkedList<>();
			int a = 1;
			for (int i = 0; i < h; i++) {
				String s = fr.nextLine();
				while(s.equals("") )
					s = fr.nextLine();
				//System.out.println("입력 : "+ s);
				for (int j = 0; j < w; j++) {
					switch (s.charAt(j)) {
					case '.': // 빈공간 -1
						a = -1;
						break;
					case '#': // 벽 0
						a = 0;
						break;
					case '@': // 시작위치 1
						a = 1;
						position.offer(new Pair(i, j));
						break;
					case '*':// 불 2
						a = 2;
						fire.add(new Pair(i, j));
						break;
					}
					visit[0] = true;
					map[i][j] = a;
				}
			}
// 처음부터 네 변일경우 탈출완료.
			if (position.peek().x * position.peek().y == 0 || position.peek().x == h - 1 || position.peek().y == w - 1)
			{
				answer += (time+1+"\n");
				continue;
			}

			while (!finish) {
				time++;// 1초 경과
				// 불이 먼저 납니다.
				size = fire.size();
				for (int k = 0; k < size; k++) {
					Pair cur = fire.poll();

					for (int i = 0; i < 4; i++) {
						int nx = dx[i] + cur.x;
						int ny = dy[i] + cur.y;
						if (nx < 0 || ny < 0 || nx > h - 1 || ny > w - 1)
							continue;
						if (map[nx][ny] == 2 || map[nx][ny] == 0) // 벽이나 불을 만나면 ㅌㅌ
							continue; // 방문한적있으면 ㅃㅃ
						map[nx][ny] = 2; // 불태웁니다.
						fire.offer(new Pair(nx, ny));
					}
				}
				// 사람이 이동합니다.
				size = position.size();
				for (int k = 0; k < size; k++) {
					Pair cur = position.poll();// 사람 위치 큐에서 하나 꺼내서 확인합니다.

					for (int i = 0; i < 4; i++) {
						int nx = dx[i] + cur.x;
						int ny = dy[i] + cur.y;
						if (nx < 0 || ny < 0 || nx > h - 1 || ny > w - 1)
							continue;
						if (map[nx][ny] != -1)
							continue; // 이동 못하는 곳 무시

						if (nx * ny == 0 || nx == h - 1 || ny == w - 1)// 네 변에 도달했을경우 탈출 완료.
						{
							finish = true;
							isarrival = true;// 반목문 종료
							break;
						}
						map[nx][ny] = 1; // 불이없는 곳으로 이동합니다.
						// System.out.println(nx+","+ny);
						position.offer(new Pair(nx, ny));
					}
					if (finish)
						break;// 강제 종료
				}
				if (position.size() == 0)
					break; // 더이상 이동 못해 ?종료

			}

			if (isarrival) {
				answer += (time + 1 + "\n");
			} else
				answer += ("IMPOSSIBLE\n");
			fire.clear();
			position.clear();
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