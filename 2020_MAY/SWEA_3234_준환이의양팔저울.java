package _0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	
	static int N,cnt,sum;
	static int[] src,arr;
	static boolean[] visit;
    static int exp[] = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
    static int fact[] = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	
	static void go(int idx,int left, int right, int target) {
		if(idx == target) {
			cnt++;
		}else {
			
			
			if(left >= sum - left) {
				cnt += exp[N-idx] * fact[N-idx];
				return;
			}
			
			for(int i=0;i<src.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					go(idx+1,left+src[i],right,N);
					
					if (left - (src[i] + right) >= 0)
						go(idx + 1, left, right + src[i], N);
					
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
			sb.append("#" +t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			src =new int[N]; cnt =0; sum=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				src[i] = Integer.parseInt(st.nextToken());
				sum += src[i];
			}

			visit = new boolean[src.length];
			go(0,0,0,N);
			sb.append(cnt).append("\n");
			
			
		}
		System.out.println(sb);
		
	}

}
