import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	
	static int K,N,M;
	static int[][] board;
	static boolean[][][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] hdx = {1,2,1,2,-1,-2,-1,-2};
	static int[] hdy = {2,1,-2,-1,-2,-1,2,1};
	static int ans = -1;
	
	static class Point{
		int x,y;
		int step, hmove;
		public Point(int x, int y, int step, int hmove) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
			this.hmove = hmove;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[K+10][N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0,0,0));
		visit[0][0][0] =true;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			boolean flag = false;
			if(tmp.x == N-1 && tmp.y == M-1) {
				ans = tmp.step; flag=true;
			}
			if(flag) break;
			if(tmp.hmove <K) {
				for(int dir=0;dir<hdx.length;dir++) {
					int nx = tmp.x+hdx[dir];
					int ny = tmp.y+hdy[dir];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(visit[tmp.hmove+1][nx][ny] || board[nx][ny]==1) continue;
					q.offer(new Point(nx,ny,tmp.step+1,tmp.hmove+1));
					visit[tmp.hmove+1][nx][ny] = true;
				}
			}
			
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x+ dx[dir];
				int ny = tmp.y+dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(visit[tmp.hmove][nx][ny] || board[nx][ny] == 1) continue;
				q.offer(new Point(nx,ny,tmp.step+1,tmp.hmove));
				visit[tmp.hmove][nx][ny] = true;
			}
		}
		
		System.out.println(ans);
		
		
	}
}
