import java.util.Scanner;


public class Main {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	

	public static void print(int[] arr1) {
		for(int i=0;i<arr1.length;i++)
			sb.append(arr1[i]).append(" ");
		sb.append("\n");
	}
	
	public static void go(int idx) {
		if(idx == m) {
			print(arr); return;
		}else {
			
			for(int i=1;i<=n;i++) {
				arr[idx] =i;
				go(idx+1);
				
			} 
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		
		go(0);
		System.out.println(sb);
		
		
	}
}
