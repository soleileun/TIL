package _0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양 {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] board;
	static ArrayList<ArrayList<Cell>> list;
	static int N,M,K;
	static int size = 400;
	
	static int check(int[][] board) {
		int cnt=0;
		for(int i=0;i<N+K;i++) {
			for(int j=0;j<M+K;j++) {
			if(board[i][j] !=0 && board[i][j] !=-1) 
				cnt++;
			}
		}
		return cnt;
	}
	
	static void solve() {
		Queue<Cell> q= new LinkedList<>();
		for(int x =9; x>=0;x--) {
			for(int s=0;s<list.get(x).size();s++) {
				q.offer(list.get(x).get(s));
			}
		}
		while(!q.isEmpty()) {
			Cell tmp = q.poll();;
			if(tmp.life == 0 && tmp.visit) {
				board[tmp.i][tmp.j] = -1;
				continue;
			}
			if(tmp.time ==0) continue;
			if(tmp.life !=0) {
				q.offer(new Cell(tmp.i, tmp.j, tmp.x, tmp.life-1, tmp.time-1, tmp.visit));
				continue;
			}
			q.offer(new Cell(tmp.i, tmp.j, tmp.x, tmp.x, tmp.time, true));
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.i + dx[dir];
				int ny = tmp.j + dy[dir];
				if(0<=nx && nx <size && 0<=ny && ny <size && board[nx][ny] ==0) {
				board[nx][ny] = tmp.x;
				q.offer(new Cell(nx,ny,tmp.x,tmp.x,tmp.time-1,false));
				}
			}
		}
		
	}

	static class Cell{
		int i;
		int j;
		int x;
		
		int life;
		int time;
		boolean visit;
		public Cell(int i, int j, int x, int life, int time, boolean visit) {
			super();
			this.i = i;
			this.j = j;
			this.x = x;
			this.life = life;
			this.time = time;
			this.visit = visit;
		}
		

	}
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc =Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N+K][M+K];
			list = new ArrayList<ArrayList<Cell>>();
			
			for(int i=0;i<10;i++)
				list.add(new ArrayList<>());
	
			for(int i=(K/2);i<N +(K/2);i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=(K/2);j<M+(K/2) ;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					board[i][j] = tmp;
					if(board[i][j] !=0) {
						int idx = board[i][j] -1;
						list.get(idx).add(new Cell(i,j,board[i][j],board[i][j],K,false));
					}
				}
			}
			
			solve();
			int ans = check(board);
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
