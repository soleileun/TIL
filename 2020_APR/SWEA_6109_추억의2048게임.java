package _0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_6109_추억의2048게임 {
	
	
	static int[][] board;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
	
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t+ "\n");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			board= new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//여기까지 입력받음 
			
			if(s.equals("up")) {
				Queue<Integer> q  = new LinkedList<Integer>();
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[j][i] != 0) {
							q.add(board[j][i]);	
							board[j][i] = 0;
						}
					}
					int idx =0;
					while(!q.isEmpty()) {
					int tmp1 = q.poll();
					int tmp2;
					if(!q.isEmpty()) {
					 tmp2= q.peek();
					}else {
						tmp2=0;
					}
				
					if(tmp1 == tmp2) {
						board[idx++][i] = tmp1*2;
						q.poll();
					}else {
						board[idx++][i]=tmp1;
						}
					}
				}
			}else if(s.equals("down")) {
				Stack<Integer> stack = new Stack<Integer>();
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[j][i] != 0) {
							stack.add(board[j][i]);	
							board[j][i] = 0;
						}
					}
					int idx =N-1;
					while(!stack.isEmpty()) {
					int tmp1 = stack.pop();
					int tmp2;
					
			
					if(!stack.isEmpty()) {
					 tmp2= stack.peek();
					}else {
						tmp2=0;
					}
					if(tmp1 == tmp2) {
						board[idx--][i] = tmp1*2;
						stack.pop();
					}else {
						board[idx--][i]=tmp1;
						}
					}
				}
				
			}else if(s.equals("left")) {
				Queue<Integer> q  = new LinkedList<Integer>();
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[i][j] != 0) {
							q.add(board[i][j]);	
							board[i][j] = 0;
						}
					}
					int idx =0;
					while(!q.isEmpty()) {
					int tmp1 = q.poll();
					int tmp2;
					if(!q.isEmpty()) {
					 tmp2= q.peek();
					}else {
						tmp2=0;
					}
				
					if(tmp1 == tmp2) {
						board[i][idx++] = tmp1*2;
						q.poll();
					}else {
						board[i][idx++]=tmp1;
						}
					}
				}
				
				
			}else if(s.equals("right")) {
				Stack<Integer> stack = new Stack<Integer>();
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[i][j] != 0) {
							stack.add(board[i][j]);	
							board[i][j] = 0;
						}
					}
					int idx =N-1;
					while(!stack.isEmpty()) {
					int tmp1 = stack.pop();
					int tmp2;
					
			
					if(!stack.isEmpty()) {
					 tmp2= stack.peek();
					}else {
						tmp2=0;
					}
					if(tmp1 == tmp2) {
						board[i][idx--] = tmp1*2;
						stack.pop();
					}else {
						board[i][idx--]=tmp1;
						}
					}
				}
				
				
			}
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(board[i][j] + " ");
				}
				sb.append("\n");
			}
			
			
			
			
		}
	
	System.out.println(sb);
	}
}
