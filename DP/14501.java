import java.io.*;
import java.util.*;

public class Main {

    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[][] map = new int[2][n];
        for(int i =0  ;i < n; i++){
            map[0][i] = fr.nextInt();//걸리는 일수.
            map[1][i] = fr.nextInt();//가치. val
        }

        int dp[] =new int[n+1];
        dp[0] = 0 ;
        for(int i = 1; i<= n; i++){//i-1번쨰 날까지 일하고 돈받는다.
            for(int j = 0 ;j < n; j++){
                //i-1날 일을 안했을 경우 . 
                dp[i] = Math.max(dp[i], dp[i-1]);
                //i-1날 일을 해서 돈받을경우.
                if(j + map[0][j] == i){
                    dp[i] = Math.max(dp[i], map[1][j] + dp[i-map[0][j]] );
                }

            }
        }
        System.out.println(dp[n]);
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