package _0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4366_정식이의은행업무 {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t + " ");
			boolean flag = false;
			
			st = new StringTokenizer(br.readLine());
			String s2 = st.nextToken();
			st = new StringTokenizer(br.readLine());
			String s3 = st.nextToken();
			
			for(int i=0;i<s2.length();i++) {
				String tmp = "";
				String s = new String();
				if(s2.charAt(i) == '1') {
					s = "0";
				}else if(s2.charAt(i) == '0') {
					s = "1";
				}
				if(i==0)
					tmp = s+ s2.substring(1,s2.length());
				else
					tmp = s2.substring(0,i) + s + s2.substring(i+1,s2.length());
				
			int result1 = Integer.parseInt(tmp,2);
			
			for(int j=0;j<s3.length();j++) {
				String tmp1 = "";
				String tmp2 = "";
				String test1 = new String();
				String test2 = new String();

				
				if(s3.charAt(j) == '0') {
					test1 = "1";
					test2 = "2";
					
					
				}else if(s3.charAt(j) == '1') {
					test1 = "0";
					test2 = "2";
					}else if (s3.charAt(j) == '2') {
					test1="0";
					test2 ="1";
				}
				
				
				if(j==0) {
				tmp1 = test1+ s3.substring(1,s3.length());
				tmp2 = test2+ s3.substring(1,s3.length());}
				else {
					tmp1 = s3.substring(0,j) + test1 + s3.substring(j+1,s3.length());
					tmp2 = s3.substring(0,j) + test2 + s3.substring(j+1,s3.length());
				}	
				int tr1 = Integer.parseInt(tmp1,3);
				int tr2 = Integer.parseInt(tmp2,3);
	
				if(tr1 == result1 || tr2 == result1) {
					flag = true; break;
				}
			}
			
			if(flag) {
				sb.append(result1).append("\n");
				break;
			}
			
			}
					}
		System.out.println(sb);
	}
}
