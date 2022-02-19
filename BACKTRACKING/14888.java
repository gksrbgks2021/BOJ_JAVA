import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static long max = - (long)1e9;
    static long min = (long) 1e9;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        int[] op = new int[4];
        for (int i = 0; i < n; i++) {
            list.add((long)fr.nextInt());
        }

        //덧셈 뺼셈 곱셈 나눗셈 의 개수를 의미한다.
        for (int i = 0; i < 4; i++)
            op[i] = fr.nextInt();
        for(int i = 0 ;i < 4;i++){
            if(op[i] > 0)
            {
                op[i]--;
                helper(list.get(0),op,i,list,1);
                op[i]++;
            }
        }
        System.out.print(max+"\n"+min);
    }

    public static void helper(long num, int op[], int index, ArrayList<Long> list, int depth) {//인덱스는 연산자번호으미
        //연산한다.
        switch (index){
            case 0:
                num += list.get(depth);
                break;
            case 1:
                num-=list.get(depth);
                break;
            case 2:
                num *= list.get(depth);
                break;
            case 3:
                //나눗셈임.
                if( num < 0){
                    num = num*(-1) / list.get(depth);
                    num *=(-1);
                }else{
                    num /= list.get(depth);
                }
                break;
        }

        if(depth == list.size()-1)//끝에 도달했으면 최대 최소 비교
        {min = Math.min(num, min);
            max = Math.max(num, max);
         return;
        }
        for(int i = 0 ;i < 4;i++){
            if(op[i] > 0)
            {
                op[i]--;
                helper(num,op,i,list,depth+1);
                op[i]++;
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