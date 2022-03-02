import java.io.*;
import java.util.*;

class Pair {
    int v;
    int val;

    Pair(int a, int b) {
        v = a;
        val = b;
    }
}

public class Main {
    static int max = 200000000;
    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int e = fr.nextInt();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
//from to weigh
        for (int i = 0; i < e; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();

            list.get(a).add(new Pair(b, c));
            list.get(b).add(new Pair(a, c));

        }
        int from = fr.nextInt();
        int to = fr.nextInt();
        int ans = -1;
        int temp;
        boolean check = false;

        int ans1 = dijkstra(1, from) + dijkstra(from, to) + dijkstra(to, n);
        int ans2 = dijkstra(1, to) + dijkstra(to, from) + dijkstra(from, n);
        ans = Math.min(ans1, ans2);
        if (ans >= max) ans = -1;
        System.out.println(ans);

    }

    public static int dijkstra(int start, int end) {
        boolean visit[] = new boolean[list.size()];
        int[] dis = new int[list.size()];
        Arrays.fill(dis, max);
        dis[start] = 0;

        for (Pair nv : list.get(start)) {
            dis[nv.v] = nv.val;
            pq.offer(nv);
        }

        while (!pq.isEmpty()) {
            Pair curV = pq.poll();
            if (dis[curV.v] < curV.val) continue;

            for (Pair nv : list.get(curV.v)) {
                if (dis[nv.v] > dis[curV.v] + nv.val) {
                    dis[nv.v] = dis[curV.v] + nv.val;
                    pq.offer(nv);
                }
            }

        }
        //   System.out.println(start+"에서거리");
//        for(int i : dis){
//            System.out.print(i+" ");
//        }
        return dis[end];
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