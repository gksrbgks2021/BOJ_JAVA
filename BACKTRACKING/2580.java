import java.io.*;
import java.util.*;


public class Main {
    public static boolean flag = false;
    public static int map[][] = new int[9][9];

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = fr.nextInt();
            }
        }
        for(int i = 1; i<= 9 ; i++){
            helper(0,0);
        }
    }

    public static void helper(int x, int y) {//재귀로 모든 배열 순회.
        if (y > 8) { //끝에 도달했을 경우.
            x += 1;
            y = 0;
        }
        if (x > 8) {//끝에 도달.
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        //해당 위치가 0이라면, 1부터 9까지 가능한 수 탐색.
       if(map[x][y] == 0){
           for(int i = 1 ;i<= 9 ; i++){
               //i값 중복 검사.
               if(possible(x,y,i)){
                   map[x][y] = i;
                   helper(x,y+1);
               }
           }
           map[x][y] = 0 ; //dfs로 찾아내기 때문에 종료시킨다.
           return ;
       }
       //0이 아니면, 호출.
        helper(x,y+1);

    }
    public static boolean possible(int x, int y, int val){
        for(int i  = 0 ; i<9 ;i++){ //행렬 검사.
            if(map[x][i] == val)return false;
            if(map[i][y] == val)return false;
        }
        int nx = (x/3)*3 ;
        int ny = (y/3)*3;
        for(int i = nx; i< nx+3; i++){
            for(int j = ny; j< ny+3;j ++){
                if(map[i][j] == val){
                    return false;
                }
            }
        }
        return true;
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