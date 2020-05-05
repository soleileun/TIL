import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_10162_전자레인지 {
	
	public static void main(String[] args) throws IOException {
		
		//입력과 출력 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int pay = Integer.parseInt(st.nextToken());
		
		int tc = 1;
		
		for(int t=1;t<=tc;t++) {
			int[] arr = new int[3]; 
		
			 if(pay >= 300) {
				 arr[0] = pay/300;
				 pay -= arr[0]*300;
			 }
			 if(pay>=60) {
				 arr[1] = pay/60;
				 pay -= arr[1]*60;
			 }
			 arr[2] = pay/10;
			 pay -= arr[2]*10;
			 
			
			 if(pay != 0) {
			 sb.append("-1").append("\n");
			 } else {
				 sb.append(arr[0] + " ").append(arr[1] + " ").append(arr[2]).append("\n");
				 }
		}
		System.out.println(sb);
		
	}
}
