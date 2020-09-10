import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_홈방범서비스 {
	static int N,M,max,ans;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		
		for(int t=1;t<=tc;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = 0;
			board = new int[N][N];
			ans = 1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int cnt =0;
					Queue<Point> q= new LinkedList<>();
					visit = new boolean[N][N];
					q.add(new Point(i,j,1));
					if(board[i][j] == 1) cnt++;
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int size = q.size();
						int now =q.peek().step;
						for(int iter=0;iter<size;iter++) {
							Point tmp = q.poll();
//							now = tmp.step;
							for(int dir=0;dir<4;dir++) {
								int nx = tmp.x+dx[dir];
								int ny = tmp.y+dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(visit[nx][ny]) continue;
								q.add(new Point(nx,ny,tmp.step+1));
								if(board[nx][ny] == 1) cnt++;
								visit[nx][ny] = true;
							}
						}
						int cost = now * now + (now+1)*(now+1);
						int money = cnt * M;
						if(money-cost>=0) {
							ans = Math.max(ans,cnt);
							}
					}
				}
			}
		
				sb.append(ans).append("\n");
			
			
			
		}
		System.out.println(sb);
		
	}

}
