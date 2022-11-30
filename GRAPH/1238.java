import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Pair {//정점 나타내는 클래스 
	int v;
	int dis;
	Pair(int a, int b){
		v = a;
		dis = b;
	}
	public int getV() {
		return this.v;
	}
	public int getDis() {
		return this.dis;
	}
}
public class Main {
	List<List<Pair>> graph1;
	List<List<Pair>> graph2;
	PriorityQueue<Pair> pq;
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
			m.Solution();
	}
	
	public void Solution() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		graph1 = new ArrayList<>();
		graph2 = new ArrayList<>();
		
		pq =new PriorityQueue<Pair>((a,b)->a.dis-b.dis);
		
		//입력처리
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());//시작 정점.
		
		for(int i = 0;i < m+1 ;i++) {
			graph1.add(new ArrayList<>());
			graph2.add(new ArrayList<>());
		}
		
		for(int i =0 ;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Pair d = new Pair(b,c);
			
			graph1.get(a).add(d);//가는 길
			graph2.get(b).add(new Pair(a,c));//오는 길
			
			//pq.offer(d);
			
		}
		int[] dst1 = new int[n+1];
		int[] dst2= new int[n+1];
		
		Arrays.fill(dst1, Integer.MAX_VALUE);
		Arrays.fill(dst2, Integer.MAX_VALUE);
		
		dijkstra( graph1,x, new boolean[n+1], dst1);
		dijkstra( graph2,x, new boolean[n+1], dst2);
		
		int ans = 0; 
		for(int i = 1 ;i< dst1.length; i++) {
			if(i != x)
				ans = Math.max(ans, dst1[i]+dst2[i]);
		}
		System.out.println(ans);
		
	}
	public void dijkstra(List<List<Pair>> graph,int startV, boolean[]visit, int[] dst) {
		
		pq.offer(new Pair(startV, 0));//초기화.
		dst[startV] = 0;
		int ans = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Pair nextE = pq.poll();//다음 정점 
			
			int dist = nextE.getDis(); //현재 노드까지의 비용 
			int nv = nextE.getV();
			
			if(dst[nv] < dist)//다음 노드 방문 처리 
				continue;
			
				/*인접 노드 확인*/
			for(Pair x : graph.get(nv)) {
				/*현재 최단거리 + 현재 연결된 노드 비용*/
				int cost = dst[nv] + x.getDis();
				//System.out.println(cost);
				/*다음 정점 잇는게 더 최단인 경우*/
				if(cost < dst[x.getV()]) {
					dst[x.getV()] = cost;
					pq.offer(new Pair(x.getV(),cost));
				}
			}
		}
		
		
	}
}
