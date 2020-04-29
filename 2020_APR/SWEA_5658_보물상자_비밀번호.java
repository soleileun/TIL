package _0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자_비밀번호 {

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
			
		
			//System.out.println(Arrays.toString(ch));

			ArrayList<Integer> arr = new ArrayList<Integer>();

			for(int i=0;i<N-(N/4)+1;i++) {
				String str = s.substring(i,i+N/4);
				int result = Integer.parseInt(str,16);
				if(arr.contains(result))
					continue;
				else
					arr.add(result);
			}
			for(int i=N-(N/4);i<N;i++) {
				String str = s.substring(i,N) + s.substring(0,N/4 -(N-i));
				int result = Integer.parseInt(str,16);
				if(arr.contains(result))
					continue;
				else
					arr.add(result);
			}
			arr.sort(null);
			Collections.reverse(arr);
			sb.append(arr.get(K-1)).append("\n");
		}
		
		System.out.println(sb);
		
		
		
	}
}
