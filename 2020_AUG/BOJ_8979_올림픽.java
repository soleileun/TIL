import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8979_¿Ã¸²ÇÈ {
	static class Rank{
		int num;
		int x;
		int y;
		int z;
		int result;
		public Rank(int num, int x, int y, int z, int result) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
			this.result = result;
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		Rank[] arr = new Rank[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[n] = new Rank(n,x, y, z,0);
		}
		Arrays.sort(arr, new Comparator<Rank>() {

			@Override
			public int compare(Rank o1, Rank o2) {
				if(o1.x > o2.x) return -1;
				else if(o1.x == o2.x) {
					if(o1.y > o2.y) return -1;
					else if( o1.y==o2.y) {
						if(o1.z >o2.z) return -1;
						else return 1;
					}
				}
				return 1;
			}
		});
		int cnt = 1;
		int sum =0;
		arr[0].result = cnt;
		Rank memo = arr[0];
		for(int i=1;i<arr.length;i++) {
		Rank tmp = arr[i];
		if(tmp.x == memo.x && tmp.y == memo.y && tmp.z == memo.z) {
			arr[i].result = cnt;
			sum++;
		}else {
			if(sum == 0) {
				arr[i].result = ++cnt;
				
			}else {
				cnt +=sum+1;
				arr[i].result = cnt;
				
			}
			memo=arr[i];
		}
		
		}
		int ans =-1;
for(int i=0;i<arr.length;i++) {
	System.out.println(arr[i].toString());
	if(arr[i].num == T-1) ans = arr[i].result;
}
System.out.println(ans);
	
		
		
	}
	}

	

