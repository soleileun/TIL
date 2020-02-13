package swea_prob;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1861 {
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	
	static class Point {
		int x;
		int y;
		int v;
		public Point() {
			
		}
		public Point(int x, int y ,int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}
		
	}

	
	static void go(int x,int y, int cnt) {
		
	}

	public static void main(String[] args) {

		
		StringBuilder sb= new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t =1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			int N= sc.nextInt();
			int max = Integer.MIN_VALUE;
			int [][] board = new int[N][N];
			//boolean [][] visit = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int ans=-1; Point room = new Point();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					Stack<Point> st = new Stack<>();
				
					st.push(new Point(i,j,board[i][j]));
					int size=0;
					boolean f =false;
					while(true) {
						Point tmp = st.peek();
						
						int cnt=0;
						for(int dir=0;dir<4;dir++) {
				
							int nx = tmp.x+dx[dir];
							int ny = tmp.y+dy[dir];
							
							if(nx<0||nx>=N||ny<0||ny>=N) {
								cnt ++;
								if(cnt == 4) {
									f=true;	break;}
								continue;
							}
							if(board[nx][ny] != tmp.v+1) {
								cnt++;
								if(cnt == 4) {
									f=true;	break;}
								continue;
							}
							
							st.push(new Point(nx,ny,tmp.v+1));
							break;
							//size = st.size();
							
						}
//						if(size == st.size())
//							break;
						if(f) break;
					}
					
				//	if(f) break;
					
					if(st.size()>=max) {
						if(st.size() == max) {
							if(board[room.x][room.y]>board[i][j])
								{room.x = i; room.y=j;}}
						else
							{
							max = st.size();
							room.x = i; room.y=j;
							room.v= max;
							}
					}
			
				}
				
			}
			
			
		sb.append(board[room.x][room.y] + " " + max).append("\n");
			
			
		}
		
		
System.out.println(sb);
	}

}
