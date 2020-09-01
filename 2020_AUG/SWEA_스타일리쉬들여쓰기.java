import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_스타일리쉬들여쓰기 {
	static int N,M;
	static int[] master,me;
	static ArrayList<int[]> arr, myline;
	
	static boolean go(int x, int y, int z) {
		int tmp[] = new int[6];
	
		for(int i=0;i<N-1;i++) {
			int [] now = arr.get(i);
			for(int j=0;j<6;j++) {
				tmp[j] +=now[j];
			}
			int result = x*(tmp[0]-tmp[1])+y*(tmp[2]-tmp[3])+z*(tmp[4]-tmp[5]);
			if(result == master[i+1]) continue;
			else return false;
		}
		return true;
	}
	
	static void check(int x, int y, int z) {
		int tmp[] = new int[6];

		for(int i=0;i<M-1;i++) {
			int [] now = myline.get(i);
			for(int j=0;j<6;j++) {
				tmp[j] +=now[j];
			}
			int result = x*(tmp[0]-tmp[1])+y*(tmp[2]-tmp[3])+z*(tmp[4]-tmp[5]);
			if(me[i+1] == -10)
				me[i+1]=result;
			else if(me[i+1] !=result)
				me[i+1] = -1;
		}
	}
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			master = new int[N];
			arr = new ArrayList<>();
			myline = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				int cnt =0; boolean flag = false;
				int[] tmp = new int[6]; 
				for(int s=0;s<str.length();s++) {
					if(str.charAt(s) == '.') {
					if(flag) continue;
					else cnt++;
					}else {
						flag = true;
						if(str.charAt(s) == '(') tmp[0]++;
						else if(str.charAt(s) == ')') tmp[1]++;
						else if(str.charAt(s) == '{') tmp[2]++;
						else if(str.charAt(s) == '}') tmp[3]++;
						else if(str.charAt(s) == '[') tmp[4]++;
						else if(str.charAt(s) == ']') tmp[5]++;
					}
				}
				master[i] = cnt;
				arr.add(tmp);
			}
			for(int i=0;i<M;i++) {
				String str = br.readLine();
				int[] tmp = new int[6];
				for(int s=0;s<str.length();s++) {
					if(str.charAt(s) == '(') tmp[0]++;
					else if(str.charAt(s) == ')') tmp[1]++;
					else if(str.charAt(s) == '{') tmp[2]++;
					else if(str.charAt(s) == '}') tmp[3]++;
					else if(str.charAt(s) == '[') tmp[4]++;
					else if(str.charAt(s) == ']') tmp[5]++;
				}
				myline.add(tmp);
			}
			me = new int[M];
			for( int i=1;i<me.length;i++)
				me[i] = -10;
			
			for(int i=1;i<=20;i++) {
				for(int j=1;j<=20;j++) {
					for(int k=1;k<=20;k++) {
						if(go(i,j,k)) {
							check(i, j, k);
						}
						
					}
				}
			}
			sb.append("#"+t+" ");
			for(int x=0;x<me.length;x++)
				sb.append(me[x] + " ");
				sb.append("\n");
		}
		System.out.println(sb);
	}
}
