import java.util.*;
import java.io.*;

class Block {
	int x;
	int y;
	int count = 1;

	Block(int a, int b, int c) {
		x = a;
		y = b;
		count = c;
	}
}

public class Main {
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int N, M;

		N = fr.nextInt();// 가로 칸의수
		M = fr.nextInt();// 세로 칸의 수

		int[][] map = new int[N][M];
		visit = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String s = fr.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] =  s.charAt(j) - '0';
			}
		}
		
		int answer = bfs(map);
		System.out.println(answer);
	}

	public static int bfs(int[][] map) {
		if(map.length == 1 && map[0].length ==1)return 1;
		int dis =1 ;
		Queue<Block> q =new LinkedList<>();
		q.add(new Block(0,0,1));
		visit[0][0][1] = true;
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		int nx,ny;
			while(!q.isEmpty()) {
				
				int size = q.size();
				for(int k = 0 ; k<size; k++) {
					Block cur = q.poll();
					for(int i= 0 ; i< 4; i++) {
						nx = cur.x+dx[i];
						ny = cur.y+dy[i];
						if(nx < 0 || nx >= map.length || ny <0 || ny >= map[0].length
								|| visit[nx][ny][cur.count]) continue;
						
						if(nx == map.length-1 && ny == map[0].length-1)return dis+1;
						
						if(map[nx][ny] == 1)//벽을 만나씅면.
						{
							if( cur.count == 0)continue; // 벽 못 부섰어!!
							if(visit[nx][ny][0])continue;
							q.add(new Block (nx,ny,cur.count-1));
							visit[nx][ny][cur.count -1] = true;
						}
						else {
							q.add(new Block(nx,ny,cur.count));
							visit[nx][ny][cur.count] = true;
						}
					}
				}
				dis++;
			}
			
		return -1;
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