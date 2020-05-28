package _0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	
	static int N,M,R,C,L,cnt;
	static int[][] board;
	static boolean[][] visit;
	static int[][] direction = {{0},{0,1,2,3},{0,1},{2,3},{0,3}, {1,3},{1,2},{0,2} }; 
	static int[] dx = {-1,1,0,0};
	static int[] dy	= {0,0,-1,1};
	
	static class Point{
		int x,y,v;

		public Point(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}
		
	}
	
	static boolean checkPossible(Point now, Point last) {
	ArrayList<Point> arr = new ArrayList<>();
	
		for(int dir=0;dir<direction[now.v].length;dir++) {
			int nx = now.x+dx[direction[now.v][dir]]; 
			int ny = now.y+dy[direction[now.v][dir]];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			if(board[nx][ny] == 0) continue;
			arr.add(new Point(nx,ny,board[nx][ny]));
		}
	boolean flag = false;
	for(int i=0;i<arr.size();i++) {
		if(arr.get(i).x == last.x && arr.get(i).y == last.y) return true;
	}
	return flag;
	}
		
	
	//들어오는거에서 연결될수있는거를 체크 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			visit = new boolean[N][M];
			cnt=0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//가능한 방향만 탐색한다. 
			//이동하려는 지점에서 이동 가능한 지점을 넣은 array리턴.. 
			//비교해서 있다면.. 큐에 넣고 아니라면 버리기 
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(R,C,1)); cnt++;
			visit[R][C] = true;
			while(true) {
				if(q.isEmpty()) break;
				Point tmp = q.poll();
				if(tmp.v >=L) break;
				for(int dir=0;dir<direction[board[tmp.x][tmp.y]].length;dir++) {
					int nx = tmp.x+dx[direction[board[tmp.x][tmp.y]][dir]];
					int ny =tmp.y+dy[direction[board[tmp.x][tmp.y]][dir]];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(visit[nx][ny]||board[nx][ny] ==0) continue;
					if(checkPossible(new Point(nx,ny,board[nx][ny]),tmp) == false) continue;
				
					q.offer(new Point(nx,ny,tmp.v+1));
					visit[nx][ny]= true; cnt++;
				}
						
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
}
