package _0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_4050_재관이의대량할인 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
	
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			ArrayList<Integer> arr = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int tmp =Integer.parseInt(st.nextToken());
				arr.add(tmp);
			}
			
			long sum =0;
			arr.sort(null);
			Collections.reverse(arr);
			for(int i=0;i<arr.size();i++) {
				if(i%3 ==2)
					continue;
				else
					sum += arr.get(i);
			}
			
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb);
	}

}
