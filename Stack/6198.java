import java.io.*;
import java.util.*;

class Pair {
    int x;
    long y;

    //    Pair(int a, int b) {
//        v = a;
//        weight = b;
//    }
    Pair(int a, long b) {
        x = a;
        y = b;
    }
}

public class Main {
    public static long[] map;
    public static long answer = -1;

    //0 .. n 까지 한다.
    //가장 높은 것은 아무것도 못본다.
    //0번쨰는 아무도 못본다. 스택 : 10
    //1번째는 0번쨰 볼수있다. 스택 : 10 3 ( ㅈ신의 값이 스택보다 작음
    //2번째는 0번째 볼수있다. 스택 : 10 7 ( 자신의 값이 스택 top 값보다 같거나 크면, 스택 top 값보다 작아질때까지.
    //3번째는 0번째 1번째 볼수있다. 스택 :10 7 4 ( 자신의 값이 스택 top보다 작으면 ,삽입.후 계산.
    //4번째는 아무것도 못본다.
    //5번쨰는 4번째가 볼수있다.
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        Stack<Integer> s = new Stack<>();
        answer = 0;
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) s.add(fr.nextInt());
            else {
                int a = fr.nextInt();//현재 입력받는값.
               while (!s.isEmpty()&&a >= s.peek()){
                   s.pop();
               }
                s.add(a);
answer += (s.size() - 1);
            }
        }
        System.out.println(answer);


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