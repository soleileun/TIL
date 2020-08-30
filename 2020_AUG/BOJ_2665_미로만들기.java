import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2665_미로만들기 {
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][N];
		int check[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			String string = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j]=  string.charAt(j);
				check[i][j]= 987654321; 
			}
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		check[0][0] = 0;
		int min = 987654321;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int dir =0;dir<4;dir++) {
				int nx = tmp.x+dx[dir];
				int ny = tmp.y+dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(tmp.step>=check[nx][ny]) continue;
				if(nx ==N-1 && ny ==N-1) {
					if(min>tmp.step)
						min = tmp.step; continue;
				}
				if(board[nx][ny ]== '1') {
					q.add(new Point(nx, ny, tmp.step));
					check[nx][ny]= tmp.step;continue;
				}
				if(board[nx][ny]=='0') {
					
					q.add(new Point(nx, ny, tmp.step+1));
					check[nx][ny] = tmp.step+1;continue;
				}
			}
		}
		if(min == 987654321)
			System.out.println("0");
		else
			System.out.println(min);
	
		
	}

	
}