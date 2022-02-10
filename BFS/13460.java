import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;
    int color;
    Pair(int a, int b,int c){
        x =a;
        y = b;
        color = c;
    }
}

public class Main {
    public static boolean[][][][] visit;
    public static Queue<Pair> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int map[][] = new int [n][m];
        int a=0, b=0, c=0, d=0;//빨간 파란 좌표 계산용.
        visit = new boolean[n][m][n][m];
        String s ;
        for(int i = 0 ; i< n;i++){
            s = fr.nextLine();
            while(s.equals("") )s = fr.nextLine();
            //System.out.println("현재입력"+s);
            for(int j = 0 ;j < m ;j++){
                switch(s.charAt(j)){
                    case '#': //벽
                        map[i][j] = -2;
                        break;
                    case 'R': //빨간색 -1 파란색 1;
                        map[i][j] = 0;
                        a = i;
                        b= j;

                        q.offer(new Pair(i, j, -1));
                        break;
                    case '.':
                        map[i][j] = 0;
                        break;
                    case 'B'://파란색 방문처리
                        map[i][j] = 0;
                       c = i;
                       d = j;

                        q.offer(new Pair(i, j, 1));
                        break;
                    case 'O'://도착지점.
                        map[i][j] = 2;
                }
            }
        }
//        for(int i[] : map){
//            for(int j = 0 ;j < i.length; j++){
//                System.out.print(i[j]);
//            }
//            System.out.println();
//        }
        visit[a][b][c][d] = true;
        System.out.println(bfs(map));

    }
    public static boolean priorityRed(Pair Red, Pair Blue,int dir){//빨간색의 우선순위를 출력.
        boolean flag = false;
        switch(dir){
            case  0:
                flag = (Red.x > Blue.x);
                break;
            case  1:
                flag = (Red.x < Blue.x);
                break;
            case  2:
                flag = (Red.y > Blue.y);
                break;
            case  3:
                flag = (Red.y < Blue.y);
                break;
        }
        return flag;
    }

    public static int bfs(int[][] map){
        int count = 1;
        int dx[] = {1,-1,0,0}; //아래 위 오른쪽 왼쪽
        int dy[] = {0,0,1,-1};
        boolean pRed = false;//빨간색의 우선순위 체크
        boolean continueRed  = false , continueBlue =false;
        boolean ishollRed = false, ishollBlue = false;
        boolean isanswer = false;
        int rednx, redny, bluenx, blueny;
        int finRX,finRY,finBX,finBY;
        while(!q.isEmpty()){
            int size = q.size() /2 ;
           // System.out.println("현재 이동 "+ count);
            if(count > 10)return -1;//구멍 도달 못했으면 -1 출력.

            for(int t =0 ;t < size ;t++){ //size만큼 bfs돌림
                Pair Red = q.poll();
                Pair Blue = q.poll();
                if(Red.color != -1) //꺼냈는데 빨간색이 아니면?
                {
                    Pair temp = Red; //바꿔줌
                    Red = Blue;
                    Blue = temp;
                }
               // map[Red.x][Red.y] = -1;
               // map[Blue.x][Blue.y] = 1;//체크를 해줍니다.
                for(int i = 0 ;i < 4 ;i++){//방향
                    ishollRed = false;
                    ishollBlue  = false;
                    rednx = Red.x;//빨간좌표 초기화
                    redny = Red.y;
                    bluenx = Blue.x;//파란좌표 초기화
                    blueny = Blue.y;
                    finRX = Red.x;//최종 빨간 좌표
                    finRY = Red.y;
                    finBX = Blue.x;//최종 파란 좌표
                    finBY = Blue.y;
                    pRed = priorityRed(Red, Blue, i);//우선순위 먼저 체크해줍니다.
                 //   System.out.println("시작 좌표 :  R "+Red.x+","+Red.y+" B :"+Blue.x+","+Blue.y);
                    continueRed = true;
                    continueBlue = true;
                    while(continueRed || continueBlue){ //각자 끝날때까지 끝까지 이동함.
                        if(continueRed){//빨간색이동
                            rednx += dx[i];
                            redny += dy[i];
                            if(rednx < 1 || rednx > map.length-2  ||redny < 1 || redny > map[0].length-2
                                    ||map[rednx][redny] == -2)
                                continueRed = false;//더이상 이동불가

                            else if( map[rednx][redny] == 2){
                                continueRed = false;//더이상 이동불가
                                ishollRed = true; //구멍에 빠졌음 체크.
                            }
                            else{
                                finRX = rednx;
                                finRY = redny;
                            }
                        }
                        if(continueBlue){//파란색이동
                            bluenx += dx[i];
                            blueny += dy[i];
                            if(bluenx < 1 || bluenx > map.length-2  ||blueny < 1 || blueny > map[0].length-2
                                    ||map[bluenx][blueny] == -2)
                                continueBlue = false;//더이상 이동불가

                            else if( map[bluenx][blueny] == 2){//파란색이 빠졌으면 무조건 실패
                                ishollBlue = true;
                                break;
                            }
                            else{
                                finBX = bluenx;
                                finBY = blueny;
                            }
                        }
                    }//끝까지 이동완료
                 //  답 패턴이 나오면? ㄱㄱ
                    if(ishollRed && !ishollBlue){
                        isanswer = true;
                        break;
                    }
                    //두 좌표가 같으면 다시 한번 더 이동.
                    if(!ishollBlue &&((finRX == finBX) && (finRY == finBY)))
                    {
                        if(pRed)//빨간색이 먼저 이동한거면.
                        {
                            finBX -= dx[i];
                            finBY-= dy[i];
                        }
                        else{ //파란색이 먼저 이동했으면
                            finRX -= dx[i];
                            finRY-= dy[i];
                        }
                    }
                   // System.out.println("Red : "+finRX+","+finRY+" Blue: "+finBX+","+finBY);
                    if(ishollBlue || visit[finRX][finRY][finBX][finBY])continue;//방문한적있으면, 큐 삽입 x
                    visit[finRX][finRY][finBX][finBY] =true;//방문처리해주고. 큐에 삽입.
                    q.offer(new Pair(finRX,finRY,-1));//빨간색 추가
                    q.offer(new Pair(finBX,finBY,1));//파란색 추가
                    // System.out.println("Red : "+finRX+","+finRY+" Blue : "+finBX+","+finBY);
                }
                //방향이동이 끝나고, 원래 지점 초기화.

               // map[Red.x][Red.y] = 0;
               // map[Blue.x][Blue.y] = 0;
            }
            if(isanswer)//답이 나왔으면
            {
                break;
            }
            count++;
        }
        if(isanswer)
            return count;
        else
            return -1;
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