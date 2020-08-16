import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visit;
	
	static class Point{
		int x;
		int y;
		char val;
		public Point(int x, int y, char val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	board = new char[N][N];
	visit = new boolean[N][N];
	for(int i=0;i<N;i++) {
		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		for(int j=0;j<s.length();j++) {
			board[i][j] = s.charAt(j);
		}
		
	}
	int cnt1=0,cnt2=0;
	Queue<Point> queue = new LinkedList<Point>();
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(visit[i][j]) continue;
			cnt1++;
			queue.add(new Point(i, j, board[i][j]));
			visit[i][j]= true;
			int x =i,y=j;
			while(!queue.isEmpty()) {
				Point tmp = queue.poll();
				for(int dir=0;dir<4;dir++) {
					int nx = tmp.x+dx[dir];
					int ny = tmp.y+dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(visit[nx][ny]) continue;
					if(board[nx][ny] == tmp.val) {
						queue.add(new Point(nx, ny, board[nx][ny]));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
	queue.clear();
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(board[i][j]== 'B'||board[i][j]== 'R'  )continue;
			else if(board[i][j] == 'G') {
				board[i][j]= 'R'; 
			}
		}
	}
	visit= new boolean[N][N];
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(visit[i][j] )continue;
			cnt2++;
			queue.add(new Point(i, j, board[i][j]));
			visit[i][j]= true;
			while(!queue.isEmpty()) {
				Point tmp = queue.poll();
				for(int dir=0;dir<4;dir++) {
					int nx = tmp.x+dx[dir];
					int ny = tmp.y+dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(visit[nx][ny]) continue;
					if(board[nx][ny] == tmp.val) {
						queue.add(new Point(nx, ny, board[nx][ny]));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
	System.out.println(cnt1 + " " +cnt2);
	

}
}
