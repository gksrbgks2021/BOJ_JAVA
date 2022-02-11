import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    int color;

    Pair(int a, int b, int c) {
        x = a;
        y = b;
        color = c;
    }
}

public class Main {
    public static String[] str = {"1", "00"};
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        //00 또는 1 타일을 붙인다.
        //00 타일 뒤엔 f(n-2)번째에서 구한 타일을 붙인다.
        //1 타일 뒤에는 f(n-1)번째에서 구한 타일을 붙인다.
        //이 두개는 서로 독립적이다. 합사건을 구하면 f(n) =f(n-1) + f(n-2)
        int dp[] =new int[N+1];
        dp[0] = 0 ;
        dp[1] = 1;
        if(N > 1 )
        dp[2] = 2;
        for(int i = 3 ;i <= N ;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[N]);
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