import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int map[][] = new int[T+2][2];
		
		for(int i =1 ;i < T+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt( st.nextToken());
			int b = Integer.parseInt( st.nextToken());
			map[i][0] = a;
			map[i][1] = b;
			//[day][pay]
		}
		int dp[] = new int[T+2];
	int max = -1;
		for(int day = 1; day< T+2; day++) {//day는 급여받는 날짜.
			//현재까지의 최대수익 계산.
			if(max < dp[day])max = dp[day];
			
			int nday = day + map[day][0];
			if(nday>=T+2) {
				continue;
			}
			
			dp[nday] = Math.max(dp[nday], map[day][1]+max);
		}
			System.out.println(max);
			br.close();
			bw.close();
	}
	public static void pl(int[][] a) {
		for(int i = 0; i< a.length; i++) {
			for(int j =0 ;j < a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
