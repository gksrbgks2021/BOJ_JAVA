package temp;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int m = fr.nextInt();
		int max = (int)1e9; //처음에 10000001 로 Inf값을 너무 작게 설정해주어 에러가남. 
		// n개의 도시 m 개의 버스 각 버스는 비용이 있다.
		//출발 도시 번호, 버스 정보는  : 시작 도시 a
		int[][] map = new int[n][n];
		
		for(int i  =0 ;i < n; i++) {
			Arrays.fill(map[i],(int) max);
		}
		
		for (int i = 0; i < m; i++) {
			int x= fr.nextInt()-1;
			int y = fr.nextInt()-1;
			int val = fr.nextInt();
			map[x][y] = Math.min(val, map[x][y]);
		}
		
		
		for(int k = 0 ; k < n; k++) {
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < n ;j++) {
//					if(map[i][j] > map[i][k] + map[k][j])
//						map[i][j] = map[i][k] + map[k][j];
					map[i][j] = Math.min(map[i][j],  map[i][k]+map[k][j]);
				}
			}
		}
		for(int i = 0 ; i< n ;i++) {
			map[i][i] = 0; //자기 자신에 대한 비용 0 
		}
		for(int i =0 ;i < n ;i++) {
			for(int j = 0 ; j < n;j++) {
				if(map[i][j] == max)map[i][j] = 0;
				System.out.print(map[i][j]+" ");
			}
		System.out.println();}
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