package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=x1;j<x2;j++) {
				for(int k=y1;k<y2;k++) {
					board[j][k] = 1;
				}
			}
		}
		

		Queue<Point> q = new LinkedList<>();
		int count =0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1 || visit[i][j]) continue;
				
				count++;
				q.offer(new Point(i,j));
				visit[i][j] = true;
				int area=0;
				while(!q.isEmpty()) {
					area++;
					Point tmp = q.poll();
					
					for(int dir=0;dir<4;dir++) {
						
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];
						
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(board[nx][ny] == 1 || visit[nx][ny] ) continue;
						
						q.offer(new Point(nx,ny));
						visit[nx][ny] = true;
 					}
				}
			arr.add(area);
				
			}
		}
		
		arr.sort(null);
		System.out.println(count);
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i) + " ");
		}
		
	}

}
