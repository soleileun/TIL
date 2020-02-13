package swea_prob;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1258 {
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		

		
	}
	
	static int[][] board ;
	static boolean[][] visit;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=tc;t++) {
		sb.append("#").append(t).append(" ");
		
		int N = sc.nextInt();
		board = new int[N][N+1];
		visit = new boolean[N][N+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = sc.nextInt();
			}
		}

		ArrayList<Point> p =new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 0 || visit[i][j] ) 
					continue;
				
				int k=j;
				while(board[i][k] !=0) {
					visit[i][k] = true;
					k++;
					if(k >=N) {break;}
					
				}
				int b=i;
				boolean f=true;
				while(true) {
					for(int a=j;a<k;a++) {
						if(board[b][a] !=0) {
							visit[b][a] =true;
							if(a ==k-1) {
									b++;
							}
							if(b==N) {
								f=false;
								break;
							}
							continue;}
						else {
							f=false;
							break;
							}
					}
					
					
					
					
					if(!f) break;
					
				}
				
				
				k=k-j;
				b=b-i;
				p.add(new Point(b,k));
				
				
					
				}
			}
			
		p.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.r * o1.c <o2.r * o2.c) return -1;
				else if(o1.r * o1.c == o2.r * o2.c) {
					if(o1.r < o2.r) return -1;
				}
				return 1;
			}
		});
		
		sb.append(p.size() + " ");
		
		for(int pp=0;pp<p.size();pp++) {
			sb.append(p.get(pp).r + " " + p.get(pp).c + " ");
		}
		sb.append("\n");
			
		}
		
		System.out.println(sb);
	}

}
