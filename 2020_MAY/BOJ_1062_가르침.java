package _0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {

	static int N,K;
	static int[] src = new int[26];
//	static int[] src = {1,2,3,4,5,6};
	static boolean[] visit;
	static int[] arr;
	static String re="antic";
	static ArrayList<String>s;
	static int max = Integer.MIN_VALUE;
	static void go(int idx, int before) {
		if(idx == arr.length) {
			//System.out.println(Arrays.toString(arr));
			//System.out.println("v : " +Arrays.toString(visit));
			int cnt =0;
			for(int i=0;i<s.size();i++) {
				String tmp=s.get(i);
				boolean flag = true;
				for(int j=0;j<tmp.length();j++) {
					if(visit[tmp.charAt(j)-'a']) continue;
					else flag = false;
					if(!flag) break;
				}
				if(!flag) continue;
				cnt++;
			}
			if(cnt >max)
				max = cnt;
			
		}else{
			for(int i=before;i<src.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					arr[idx] = src[i];
					go(idx+1,i+1);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K<5) {
			System.out.println("0");
			return;
		}
		
		s = new ArrayList<String>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			tmp = tmp.substring(3,tmp.length()-4);
			s.add(tmp);
		}
		for(int i=0;i<26;i++) 
			src[i] = i;
		
		arr =new int[K];
		visit = new boolean[src.length];
		for(int i=0;i<re.length();i++) {
			char c= re.charAt(i);
			arr[i]=c-'a';
			visit[arr[i]] =true;
		}
		
		go(5,0);
		System.out.println(max);
		
	}
}
