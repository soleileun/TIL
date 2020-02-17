package cheerUp;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1244 {

	static String s;
	static int[] arr;
	static int ans;
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	
	public static int makeNumber(int arr[]) {
		int sum =0;int m =1;
		for(int i=arr.length-1;i>=0;i--) {
			sum += arr[i]*m;
			m *=10;
		}
		return sum;
	}
	public static void go(int idx, int count, int change) {
		if(count == change ) {
			int tmp = makeNumber(arr);
			ans = Integer.max(ans, tmp);
			return;
			
		}else {
			for(int i=idx;i<s.length();i++) {
				for(int j=i+1;j<s.length();j++) {
					if(arr[i]<=arr[j]) {
						swap(arr,i,j);
						go(i,count+1,change);
						swap(arr,i,j);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			s = sc.next();
			int change = sc.nextInt();
			arr = new int[s.length()];
			
			for(int i=0;i<s.length();i++) {
				arr[i] = s.charAt(i)-'0';
			}
			//int cnt=0;
			ans = -98765423;
			
			go(0,0,change);
			
		//	System.out.println(Arrays.toString(arr));
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
