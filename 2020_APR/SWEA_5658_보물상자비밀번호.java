package _0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SWEA_5658_보물상자비밀번호 {

	static int N,K;
	static char[][] c;
	static ArrayList<Integer> ans;
	
	static void rotate(char[][] c) {
		char tmp= c[3][c[0].length-1];
		char next = c[0][0];
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				if(j+1==c[0].length) {
					if(i+1 ==4) {
					c[0][0] = tmp;
					}else {
						char temp =  c[i+1][0];
						 c[i+1][0] = next;
						 next = temp;
					}
				}else {
					char temp = c[i][j+1];
					c[i][j+1] = next;
					next = temp;
				}
			}
		}
	}
	
	static void calcul(char[][] c) {
		for(int i=0;i<c.length;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<c[0].length;j++) {
				sb.append(c[i][j]);
			}
			String s = sb.toString();
			int result = Integer.parseInt(s,16);
			if(ans.contains(result)) {
				continue;
			}else {
				ans.add(result);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String s = br.readLine();
			char[] ch = s.toCharArray();
			c = new char[4][N/4];
			//System.out.println(Arrays.toString(ch));
			int idx =0;
			for(int i=0;i<4;i++) {
				for(int j=0;j<N/4;j++) {
					c[i][j] = ch[idx++];
				}
			}
		//	System.out.println(Arrays.toString(c));
		//배열에맞게 넣어줬고, 
			
			ans = new ArrayList<Integer>();
			for(int i=0;i<10;i++) {
				rotate(c);
				calcul(c);
			}
			ans.sort(null);
			Collections.reverse(ans);
		//	System.out.println(ans.toString());
			//System.out.println(ans.get(K-1));
		sb.append(ans.get(K-1)).append("\n");
		}
		
		System.out.println(sb);
		
		
		
	}
}
