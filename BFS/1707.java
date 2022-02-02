
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int visit[];

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();

		int T = fr.nextInt();
		String answer = "";

		while (T-- > 0) {
			int V = fr.nextInt();
			int E = fr.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				list.add(new ArrayList<>());
			}
			visit = new int[V];
			for (int i = 0; i < E; i++) {
				int a = fr.nextInt() - 1;
				int b = fr.nextInt() - 1;
				list.get(a).add(b);
				list.get(b).add(a);
			}
			paint();
			answer += check();
			answer+= "\n";
		}
		
		System.out.println(answer);
	}

	public static String check() {
		
		for(int i =0 ; i< list.size(); i++) {
			for(int j =  0 ; j < list.get(i).size(); j++) {
				int n = list.get(i).get(j);
				if(visit[i] == visit[n])return "NO";
			}
		}
		return "YES";
	}

	public static void paint() {
		Queue<Integer> q = new LinkedList<>();
		int color = 1;
		int next;
		for (int i = 0; i < list.size(); i++) { // 모든 정점ㅇ에 대해 탐색하며 색칠한다.
			color = 1;
			if(visit[i] == 0)//색칠 안되잉ㅆ으면
			visit[i] = color;// 기본값 1로 색칠.
			q.add(i);
			while (!q.isEmpty()) {
				int temp = q.poll();
				color = 1; //기본값 1
				if (visit[temp] != 0)//현재 색칠이 되있으면 ? 
					{
					color =3 - visit[temp];
					}
				for (int k = 0; k < list.get(temp).size(); k++) {
					next = list.get(temp).get(k);
					if (visit[next] == 0)// 색칠 안했으면 칠해주고 탐색 계속 함.
					{
						visit[next] = color; // 1이면 2로 2면 1로 색칠.
						q.add(next);
					}
				}
			}
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