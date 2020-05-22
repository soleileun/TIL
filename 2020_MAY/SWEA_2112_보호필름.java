package _0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

	static int D,W,K;
	static int[][] board,copy;
	static int[] src,arr;
	static boolean[] visit;
	static int[] tarr , tsrc = {0,1};
	static boolean flag = true;
	static int min = Integer.MAX_VALUE;
	static int cnt =0;

	static void go(int idx, int before, int target) {
		cnt++;
		if(idx == target ) {
		System.out.println(Arrays.toString(arr));
		tarr = new int[arr.length];
		copy = new int [D][W];
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				copy[i][j] = board[i][j];
			}
		}
		go2(0);
		if(min != Integer.MAX_VALUE) return;
		}else {
			for(int i=before;i<src.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					arr[idx] = src[i];
					go(idx+1, i,target);
					visit[i]=false;
				}
			}
		}
	}
	
	static void go2(int idx) {
		if(idx == tarr.length) {
			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<W;j++) {
					copy[arr[i]][j] = tarr[i];
				}
			}
			
			if(checkBoard(copy)) {
				min = tarr.length;
				return;
			}		
		}else {
			for(int i=0;i<tsrc.length;i++) {
				tarr[idx] = tsrc[i];
				go2(idx+1);
			}
		}
	}
	
	static boolean checkBoard(int[][] board) {
		
		for(int i=0;i<W;i++) {
			int before = board[0][i];
			int cnt = 0;boolean test = false;
			for(int j=0;j<D;j++) {
				if(board[j][i] == before) cnt++;
				else {
					before = board[j][i];
					cnt=1;
				}
				if(cnt >= K) {test = true; continue; }
			}
			if(test) continue;
			else 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board=new int[D][W]; flag = true;
			min = Integer.MAX_VALUE;
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			src = new int[D]; 
			visit = new boolean[D];
			for(int i=0;i<D;i++) src[i] = i;
			
			if(K==1) min =0;
			else {
			if(checkBoard(board)) min = 0;
			else {
			for(int i=1;i<=D;i++) {
				arr=new int[i];
				
				go(0,0,i);
				if(min != Integer.MAX_VALUE) break;
			}
			}
			}
			
			//System.out.println(cnt);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

}
