import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	
	static int N,M;
	static int min = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Point implements Comparable<Point>{
		int x,y,crush;

		public Point(int x, int y, int crush) {
			super();
			this.x = x;
			this.y = y;
			this.crush = crush;
		}

		@Override
		public int compareTo(Point o) {
			if(this.crush<o.crush)
				return -1;
			else
				return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(s.substring(j, j+1));
			}
		}
		
	

		visit = new boolean[N][M];
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point (0,0,0));
		visit[0][0] = true;
		
		while(!pq.isEmpty()) {
			Point tmp = pq.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(nx == N-1 && ny == M-1){
				//	System.out.println(tmp.crush);
					if(tmp.crush <min)
						min=tmp.crush;
				}
				if(visit[nx][ny]) continue;
				if(board[nx][ny] == 0) {
					pq.offer(new Point(nx,ny,tmp.crush));
					visit[nx][ny] = true;
				}
				if(board[nx][ny]==1) {
					pq.offer(new Point(nx,ny,tmp.crush+1));
					visit[nx][ny]=true;
				}
			}
		}
		if(min == Integer.MAX_VALUE)
			min = 0;
		
		System.out.println(min);
	}

}
