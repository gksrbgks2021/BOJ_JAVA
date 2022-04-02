import java.util.*;
import java.io.*;

class kmp{
	int lps[];
	String pat ;
	String txt;
	StringBuilder sb;
	
	kmp(String pat, String txt){
		this.pat = pat;
		this.txt = txt;
		sb = new StringBuilder();
	}
	public void makelps(){
		int len = 0;
		lps = new int[pat.length()];
		lps[0] = 0;
		int i =1;
		while(i< pat.length()) {
			if(pat.charAt(i) == pat.charAt(len)){
				len++;
				lps[i++] = len;
			}else {
				if(len != 0) len = lps[len-1];
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	public int matchcount() {
		int count =0 ;
		int i =0 ;
		int j =0 ; 
		int pat_l = pat.length();
		int txt_l = txt.length();
		while(i < txt_l) {
			if(pat.charAt(j) == txt.charAt(i)) {
				i++; 
				j++;
			}
			if(j == pat.length()) {
				count++;
				j = lps[j-1];
				sb.append((i - pat_l+1)).append(" ");
				
			} else if(i<txt_l && pat.charAt(j) != txt.charAt(i)){
				if(j > 0)j = lps[j-1];
				else i++;
			}
		}
		return count;
	}
	String get_sb() {
		return sb.toString();
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		String first = fr.nextLine();
		String pat = fr.nextLine();
		int count =0 ;
			kmp kk = new kmp(pat, first);
			kk.makelps();
			count+=kk.matchcount();
	
		System.out.println(count);
		System.out.println(kk.get_sb());
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
