package swea_prob;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_3109 {
	
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	
	
	static class Point {
		int x;
		int y;
		int cnt;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.cnt =0;
		}
		
	}
	
	static Stack<Point> temp = new Stack<>();

	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			int R = sc.nextInt();
			int C = sc.nextInt();
			int[][] board = new int[R][C+1];
			boolean[][] visit = new boolean[R][C+1];
			for(int i=0;i<R;i++) {
				String s = sc.next();
				for(int j=0;j<C;j++) {
					char c =  s.charAt(j);
					if( c == '.')
						board[i][j] = 0;
					else if(c == 'x')
						board[i][j] = 1;
				}
			}
			//System.out.println("now");
			//맵 세팅
			
			//Stack<Point> st = new Stack<>();
			int count =0;
			for(int i=0;i<R;i++) {
				
				Stack<Point> st = new Stack<>();
				//System.out.println("시작");
				st.push(new Point(i,0));
				//System.out.println(i + "  0" );
				visit[i][0]=true;
				while(!st.isEmpty()) {
					
					Point tmp = st.peek();
					boolean f = false;
					boolean fl = false;
					int cnt=0;
					for(int dir=0;dir<3;dir++) {
						//f = false;
						int nx = tmp.x+dx[dir];
						int ny = tmp.y+dy[dir];

						if(nx<0 ||nx>=R) {cnt++;
						if(cnt >=3) {
							visit[tmp.x][tmp.y] = true;
							
//							temp.push(new Point(tmp.x,tmp.y));
							st.pop();
							break;
						}
						continue;}
						if(board[nx][ny] == 1 || visit[nx][ny]) {cnt++;
						if(cnt >=3) {
							visit[tmp.x][tmp.y] = true;
							//temp.push(new Point(tmp.x,tmp.y));
							st.pop();
							break;
						}
						continue;}
						if(ny == C-1) {
							st.push(new Point(nx,ny));
							count ++;
							visit[nx][ny]=true;
							while(!st.isEmpty()) {
								Point tp = st.pop();
								visit[tp.x][tp.y] =true;
								//System.out.println(tp.x + " " + tp.y);
							}
							fl=true;
							break;
							}
					
//						if(tmp.cnt >=3) {
//							while(!st.isEmpty())
//								st.pop();
//							break;
//						}
						if(fl)
							break;
						
						st.push(new Point(nx,ny));
						
							break;
						//f = true;
						//visit[nx][ny]= true;
						//break;
					}
					if(fl)
						break;
					
				}
				
//				int stsize =temp.size();
//				for(int sti=0;sti<stsize;sti++) {
//					Point ttp = temp.pop();
//					System.out.println("실행됨");
//					visit[ttp.x][ttp.y] = false;
//				}
			}
			System.out.println(count);
			
	}

}
