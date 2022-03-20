import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		char[] arr1 = fr.next().toCharArray();
		char[] arr2 = fr.next().toCharArray();
		Stack<Character> s = new Stack<>();
		char[] arr3 = {'0','1','2','3','4','5','6','7','8','9'};
		
		int a, b;
		int carry = 0;
		int i = arr1.length-1 , j = arr2.length-1;
		while(i >= 0|| j>= 0) {
			a = ( i>=0 ) ? arr1[i--]-'0' : 0 ;
			b = ( j>=0 ) ? arr2[j--]-'0' : 0 ;
			carry = a+b+carry;
			s.push(arr3[carry%10]);
			carry /= 10;
			
		}
		if(carry>0)
			s.push(arr3[carry]);
		
			StringBuilder sb =new StringBuilder();
			while(!s.isEmpty()) {
				sb.append(s.pop());
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