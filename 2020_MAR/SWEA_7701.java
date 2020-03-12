package woxorgkrtmq;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7701 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
	
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append("\n");
			
			HashSet<String> hs = new HashSet<String>();
			// st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(br.readLine());
			 
			 for(int n=0;n<N;n++) {
				// st = new StringTokenizer(br.readLine());
				 String temp = br.readLine();
				 hs.add(temp);
				 
			 }
			
			 List<String> list = new ArrayList(hs);
			 list.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length())
						return 1;
					else {
						if(o1.length() ==  o2.length()) {
							for(int i=0;i<o1.length();i++) {
								if(o1.charAt(i)-'a' > o2.charAt(i)-'a')
									return 1;
								else 
									return -1;
							}
						}
						
					}
					return -1;
				}
			});
			 
			 for(int i=0;i<list.size();i++) {
				sb.append(list.get(i)).append("\n");
			 }
		}
		
		System.out.println(sb);
	}
}
