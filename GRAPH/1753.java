import java.io.*;
import java.util.*;

class Pair {
    int v; //도착 정점.
    int weight;//무게

    Pair(int a, int b) {
        v = a;
        weight = b;
    }
}

public class Main {
    public static int distance[];
    public static PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);//오름차순.

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int V = fr.nextInt(), E = fr.nextInt();
        int K = fr.nextInt(); //시작 정점의 번호
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[V + 1];
        Arrays.fill(distance, (int) 1e9);
        for (int i = 0; i < E; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
         graph.get(a).add(new Pair(b, c));//a --> b costs c
        }

        helper(K,graph);
        printAll();
    }

    public static void printAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == (int) 1e9) sb.append("INF\n");
            else
                sb.append(Integer.toString(distance[i]) + "\n");
        }
        System.out.println(sb);
    }

    public static void helper(int start, ArrayList<ArrayList<Pair>> graph ) {
      distance[start] = 0 ;//시작 정점은 0 으로 초기화.
        for(Pair nextV : graph.get(start)) {
            distance[nextV.v] = Math.min(nextV.weight, distance[nextV.v]);//중복 되는 간선 제거.
            pq.offer(nextV);//간선 추가
        }
        while(!pq.isEmpty()){
            Pair cur = pq.poll();//가장 짧은 간선 꺼낸다ㅏ.
            if(distance[cur.v] < cur.weight)//중복 간선 제거.
                continue;
            for(Pair nextV : graph.get(cur.v)){
                if(distance[nextV.v] > distance[cur.v] + nextV.weight){//다음 정점 거쳐가는게 이득이면.
                    distance[nextV.v] = distance[cur.v] + nextV.weight;
                    pq.offer(new Pair(nextV.v,distance[nextV.v]));
                }
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