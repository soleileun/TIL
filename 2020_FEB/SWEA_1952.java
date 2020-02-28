package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1952 {
	
	static int[] fee;
	static int[] month;
	static int[] arr=new int[13];
	static int[] src = {3,2,1};
	static int min;
	
	static int getSum() {
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 2)
				sum += 1;
			else
				sum+=arr[i];
		}
		return sum;
	}
	
	static void go(int idx) {
		int sum = getSum();
		if(idx==13) {
			
			{//System.out.println(Arrays.toString(arr));
			int total =0;
			int m=0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i] == 3)
				{
					int tmp =0;
					for(int x=m;x<m+3;x++)
					{
						if(x<=12)
							tmp += month[x];
					}
					if(tmp !=0)
						total += fee[2];
					m+=3;
					//continue;
				}
				else if(arr[i] == 2) {
					if(month[m] !=0)
						total +=fee[1];
					m+=1;
					//continue;
				}
				else {
					if(month[m] !=0)
						total += fee[0]*month[m];
					m+=1;
					//continue;
				}
				
				if(m >12)
					break;
				
			}
			if(total <min) {
				//System.out.println(Arrays.toString(arr));
				min = total;
				//System.out.println(total);
			}
			}
			
		}
		else {
			for(int i=0;i<src.length;i++) {
				sum += src[i];
				if(sum<=33) {
					arr[idx] = src[i];
					go(idx+1);
					}
				else {
					arr[idx] = 0;
					go(idx+1);
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
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			fee = new int[4];
			for(int i=0;i<4;i++)
				fee[i] = Integer.parseInt(st.nextToken());
			month = new int[13];
			st = new StringTokenizer(br.readLine());
			//int count = 0;
			
			for(int i=0;i<12;i++) {
				month[i] = Integer.parseInt(st.nextToken());
				//if(fee[i] != 0) count++;
			}
			min = Integer.MAX_VALUE;
			go(1);
			
			if(min>fee[3])
				min=fee[3];
			if(min>fee[2]*4)
				min = fee[2]*4;
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
		
		

	}

}
