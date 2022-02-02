import java.util.*;
import java.io.*;

class Block {
	int x;
	int y;

	Block(int a, int b) {
		x = a;
		y = b;
	}
}

public class Main {
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();

		int T, I;
		int x[] = new int[4];
		T = fr.nextInt();
		String answer = "";
		for (int t = 0; t < T; t++) {
			I = fr.nextInt();
			visit = new boolean[I][I];
			x[0] = fr.nextInt();
			x[1] = fr.nextInt();
			x[2] = fr.nextInt();
			x[3] = fr.nextInt();
			answer += bfs(new Block(x[0], x[1]), new Block(x[2], x[3]), visit);
			answer += "\n";

		}
		System.out.println(answer);

	}

	public static int bfs(Block start, Block end, boolean[][] visit) {
		if(end.x == start.x && end.y == start.y)return 0;
		int count = 0;
		int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		Queue<Block> q = new LinkedList<>();
		q.add(start);
		visit[start.x][start.y] = true;
		while (!q.isEmpty()) {	
			count++;
			int size = q.size();
			for(int k = 0 ; k< size; k++) {
				Block temp = q.poll();
				for (int i = 0; i < 8; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= visit.length || ny >= visit[0].length || visit[nx][ny])
						continue;
					if(nx == end.x && ny == end.y) {//도착지점??
						return count;
					}
					visit[nx][ny] =true;
					q.add(new Block(nx,ny));
				}
			}
	
			
		}
		return count;
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