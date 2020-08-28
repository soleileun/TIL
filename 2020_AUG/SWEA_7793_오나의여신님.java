import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님 {
	static int N,M;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Point S,D,G;
	static class Point {
		int x;
		int y;
		int step;
		public Point(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
	for( int t=1;t<=tc;t++) {
		Queue<Point> devil = new LinkedList<>();
		Queue<Point> me= new LinkedList<>();
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit= new boolean[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				if(s.charAt(j) == 'D') {
					G =new Point(i, j, 0);
					board[i][j] =8;}
				else if(s.charAt(j)=='*') {
				devil.add(new Point(i,j,0));
					board[i][j] = 4;}
				else if(s.charAt(j)=='S') {
					S =new Point(i, j, 0);
					board[i][j] =0;
					}
				else if(s.charAt(j)== '.')
					board[i][j] = 0;
				else if(s.charAt(j)=='X')
					board[i][j] = 1;
			}
		}
		int time = 0;
		
		boolean flag = false;
		//devil.add(D);
		me.add(S);
		visit[S.x][S.y]=true;
		int ans =-1;
		while(true) {
			if(flag) break;
			if(devil.size() == 0 && me.size()==0) break;
		
		while(!devil.isEmpty()) {
			if(devil.size() != 0) {
			if(devil.peek().step != time) break;}
			Point tmp = devil.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(board[nx][ny]==1) continue;
				if(board[nx][ny]==4 || board[nx][ny]==8) continue;
				board[nx][ny] =4;
				devil.add(new Point(nx, ny, tmp.step +1));
			}
		}
		
		while(!me.isEmpty()){
			if(me.size() != 0) {
				if(me.peek().step != time) break;}
			Point tmp = me.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(board[nx][ny]==1) continue;
				if(board[nx][ny]==4) continue;
				if(visit[nx][ny]) continue;
				if(nx == G.x && ny == G.y) {
					ans = tmp.step;flag =true; break;
				}
				visit[nx][ny] =true;
				me.add(new Point(nx, ny, tmp.step +1));
			}
		}
		time++;
		}
		if(ans == -1) {
			sb.append("#"+t+" ").append("GAME OVER").append("\n");
		}else {
			sb.append("#"+t+" ").append(ans+1).append("\n");
		}
	}
	System.out.println(sb);
	}
}
