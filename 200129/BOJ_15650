import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] a;
	

	public static void print(int[] arr1) {
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i] + " ");
		System.out.println();
	}
	
	public static void go(int idx,int k) {
		if(idx == m) {
			print(a);
			return;
		}else {
		
		for(int i=k;i<=n;i++) {
			a[idx]= i;
			go(idx+1,i+1);
		}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		m = sc.nextInt();
		a = new int[m];
		
		go(0,1);
		
		
	}
}
