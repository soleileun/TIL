package coffeontheplan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};	
	static int N,W,H;
	static int[][] board;
	static ArrayList<Integer> src ;
	static int[] arr;
	static int[][] cb;
	static int min;
	
	static class Point{
		int x;
		int y;
		int power;
		public Point(int x, int y,int power) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
		}
		
	}
	static int checkBoard(int[][] board) {
		int cnt=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(board[i][j] ==0)
					continue;
				else
					cnt++;
			}
		}
		return cnt;
	}
	
	static void arrangeBoard(int[][] board) {
		for(int i=0;i<W;i++) {
			Stack<Integer> stack = new Stack<Integer>();
			for(int j=0;j<H;j++) {
				if(board[j][i] != 0) {
					stack.push(board[j][i]);
					board[j][i] =0;
				}
			}
			int tmp = H-1;
			while(!stack.isEmpty()) {
				board[tmp][i] = stack.pop();
				tmp--;
			}
			}
		}
	
	
	static void go(int idx) {
		if(idx == N) {
//			if(!(arr[0] ==2 && arr[1] == 2 && arr[2] == 6)) 
//				return;
			
			
//			System.out.println(Arrays.toString(arr));
			cb = new int[H][W];
			
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					cb[i][j] = board[i][j];
				}
			}
			
			for(int i=0;i<arr.length;i++) {
				int down = arr[i];
				int num = -1;
				int line = -1;
				for(int j=0;j<H;j++) {
					if(cb[j][down] == 0) continue;
					else {
						num = j;
						break;
						}
				}
				if(num == -1)
					continue;
				
				Queue<Point> q= new LinkedList<>();
				Queue<Point> tq= new LinkedList<>();
				q.offer(new Point(num,down,cb[num][down]));
				tq.offer(new Point(num,down,cb[num][down]));
				boolean[][] visit = new boolean[H][W];
				visit[num][down] = true;
				while(!q.isEmpty()) {
					Point tmp = q.poll();
					cb[tmp.x][tmp.y] = 0;
					
					for(int dir = 0;dir<4;dir++) {
						for(int p=1;p<tmp.power;p++) {
						int nx = tmp.x + dx[dir]*p;
						int ny = tmp.y + dy[dir]*p;
						if(nx<0||nx>=H||ny<0||ny>=W) continue;
						if(cb[nx][ny] == 0 || visit[nx][ny]) continue;
						
						tq.offer(new Point (nx,ny,cb[nx][ny]));
						q.offer(new Point (nx,ny,cb[nx][ny]));
						visit[nx][ny] = true;
						cb[nx][ny]=0;
						}
					}

				}
				
				arrangeBoard(cb);
				
//				if(arr[0] ==2 && arr[1] == 2 && arr[2] == 6) {
//				System.out.println("======================================");
//				for(int r=0;r<H;r++) {
//					for(int c=0;c<W;c++) {
//						System.out.print(cb[r][c] + " ");
//					}
//					System.out.println();
//				}
//				}
	
			}
			
			int result = checkBoard(cb);
			if(min > result)
				min = result;
		
			
		}else {
			for(int i=0;i<src.size();i++) {
				arr[idx] = src.get(i);
				go(idx+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			board = new int[H][W];
			min = Integer.MAX_VALUE;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arr =new int[N];
			src = new ArrayList<Integer>();
			for(int i=0;i<W;i++) {
				src.add(i);
			}
			
			go(0);
			sb.append(min).append("\n");
			
		}
		
		System.out.println(sb);
		
		
		
	}
	
}

