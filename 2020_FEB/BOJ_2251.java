package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251 {
	static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		int[][] ans = new int[N][N];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++)
			arr.add(new ArrayList<Integer>());
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					arr.get(i).add(j);
					board[i][j] = 1;
				}
				
			}
		}
		
				
		for(int i=0;i<N;i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i);
			boolean[] visit = new boolean[N];
			
			while(!q.isEmpty()) {
				int tmp = q.poll();
				for(int r=0;r<arr.get(tmp).size();r++) {
					if(!visit[arr.get(tmp).get(r)])
					{
						q.offer(arr.get(tmp).get(r));
						visit[arr.get(tmp).get(r)] =true;
					}
				}
			}
			
			for(int r=0;r<visit.length;r++) {
				if(visit[r])
					board[i][r] = 1;
				
			}
				
		
		}

		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}
		
		
	}
}
