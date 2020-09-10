import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_보호필름 {
	static int N,M,P,ans;
	static int[][] board,copy;
	static int[] glass = {0,1};
	static int[] arr,src,arr2;
	static boolean[] visit;
	
	static boolean check(int[][] board) {
		
		for(int i=0;i<M;i++) {
			int cntA =0; int cntB=0;
			boolean flag = false;
			for(int j=0;j<N;j++) {
				if(board[j][i] == 0) {
					cntA++; cntB=0;
					if(cntA >= P) flag=true;
				}else if( board[j][i] == 1) {
					cntA=0;cntB++;
					if(cntB>=P) flag = true;
				}
			}
			if(!flag) return false;
		}
		
		return true;
	}
	static void go2(int idx, int target) {
		if(idx == target) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<M;j++)
				copy[arr[i]][j] = arr2[i];
			}
			boolean result = check(copy);
			if(result) {ans = arr.length; return ;}
			else {
				for(int i=0;i<arr.length;i++) {
					for(int j=0;j<M;j++)
					copy[arr[i]][j] = board[arr[i]][j];
				}
			}
		}else {
			for(int i=0;i<glass.length;i++) {
				arr2[idx] = glass[i];
				go2(idx+1,target);
			}
		}
	}
	
	static void go(int idx, int target, int now) {
		if(idx == target) {
//			System.out.println(Arrays.toString(arr));
			arr2 = new int[arr.length];
			go2(0,target);
			if(ans != -1) return;
		}else {
			for(int i=now;i<N;i++) {
				if(!visit[i]) {
				arr[idx] = i;
				visit[i] = true;
				go(idx+1,target,i+1);
				visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			copy = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = board[i][j];
				}
			}
			src =  new int[N];
			visit = new boolean[N];
			for(int i=0;i<N;i++) src[i] = i;
			ans = -1;
			if(check(board)) {
				sb.append("0").append("\n");
				continue;
			}
	
			for(int i=1;i<=N;i++) {
				arr = new int[i];
				go(0,i,0);
				if(ans !=-1) break;
			}
			sb.append(ans).append("\n");
			
			
		}
	System.out.println(sb);	
	}
}
