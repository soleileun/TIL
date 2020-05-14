import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

	static int [] count;
	static int result,N,M,cnt;
	static int[][] board;
	static boolean[] visit ;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			
			board = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y]=1; 
			}
			result = 0;
			
			for(int i=1;i<N+1;i++) {
				cnt = 0;
				visit = new boolean[N+1];
				// 나보다 큰 사람 찾기
				dfs(i);
				// 나보다 작은 사람 찾기 
				visit = new boolean[N+1];
				dfs_down(i);
				if(cnt == N-1) result ++;
			}
			
			
			sb.append(result).append("\n");			
		}
		System.out.println(sb);
	}

	private static void dfs_down(int idx) {
		visit[idx] = true;
		{
			for(int i=1;i<N+1;i++) {
				if(visit[i]) continue;
				if(board[i][idx] ==0) continue;
				cnt++;
				dfs_down(i);
			}
		
	}
	}

	private static void dfs(int idx) {
		visit[idx] = true;
		for(int i=1;i<N+1;i++) {
			if(visit[i]) {
				continue;
			}
				if(board[idx][i] == 0) continue;
				cnt++; dfs(i);
			}
		}
		
	}
	

