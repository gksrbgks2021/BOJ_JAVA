import java.util.*;
import java.io.*;

public class Main {
	static int[] list;
	static char[] memo;
	
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n =  fr.nextInt();
		Stack<Integer> s =new Stack<>();
		int start = 0 ;
		StringBuilder sb = new StringBuilder();
		
		while(n-- > 0) {//n번 반복
			int val = fr.nextInt();
			
			if(val > start) {
				for(int i = start+1 ; i<= val; i++) {//push한다.
					s.push(i);
					sb.append("+\n");
					
				}
				start = val;
			}
			
			else if(val != s.peek()) {
				System.out.println("NO");
				System.exit(0);//프로그램 종료
			}
			s.pop();
			sb.append("-\n");
			
		}
		System.out.println(sb);
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