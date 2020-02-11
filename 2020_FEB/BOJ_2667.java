package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667 {
	static int size;
	static int[][] board;
	static boolean[][] v;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Integer> ans = new ArrayList<>();
	
	static class Point{
		
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		size = sc.nextInt();
		board = new int[size][size];
		v = new boolean[size][size];
		for(int i=0;i<size;i++) {
			String s=sc.next();
			for(int j=0;j<s.length();j++) {
				board[i][j] =s.charAt(j)-'0';
			}
		}
		
//		for(int i=0;i<size;i++) {
//			for(int j=0;j<size;j++)
//				System.out.print(board[i][j] + " ");
//			System.out.println();
//		}
		
		
		Queue<Point> q = new LinkedList<Point>();
		int count =0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==0 || v[i][j] == true) continue;
				
				count++;
				q.offer(new Point(i,j));
				v[i][j] = true;
				board[i][j] = count;
				int area=0;
				while(!q.isEmpty()) {
					area++;
					Point tmp = q.poll();
					
				for(int dir=0;dir<4;dir++) {
					int nx = tmp.x+dx[dir];
					int ny = tmp.y+dy[dir];
					
					if(ny<0||ny>=size||nx<0||nx>=size) continue;
					if(board[nx][ny] == 0 || v[nx][ny] == true) continue;
					
					v[nx][ny] = true;
					board[nx][ny] = count;
					q.offer(new Point(nx,ny));
				}
				
				
				}
				ans.add(area);
				
				
			}
			
		}
		
//		System.out.println();
//		for(int i=0;i<size;i++) {
//			for(int j=0;j<size;j++)
//				System.out.print(board[i][j] + " ");
//			System.out.println();
//		}
		
		System.out.println(count);
		ans.sort(null);
		for(int i=0;i<ans.size();i++)
			sb.append(ans.get(i)).append("\n");
		System.out.println(sb);
			
		
		
	}

}
