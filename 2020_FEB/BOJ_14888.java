package cheerUp;

import java.util.Scanner;

public class BOJ_14888 {

	static int[] ans;
	static int[] number;
	static int[] select;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	static int calcul(int[] arr,int[] num) {
		int sum = num[0];
		for(int i=0;i<arr.length;i++) {
			int tmp = arr[i];
			if(tmp == 0)
				sum +=num[i+1];
			else if(tmp ==1)
				sum -= num[i+1];
			else if(tmp ==2)
				sum *=num[i+1];
			else if(tmp ==3)
				sum /=num[i+1];
		}
		return sum;
	}
	
	
	static void go(int idx,int n) {
		if(idx ==n) {
			//print(ans);
			int result = calcul(ans, number);
			//System.out.println("result : "+result);
			if(result<min)
				min = result;
			if (result>max)
				max = result;
		}else {
			for(int i=0;i<select.length;i++) {
				if(!v[i]) {
				ans[idx] = select[i];
				v[i] = true;
				go(idx+1,n);
				v[i] = false;
				}
			}
		}
	}
	
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		number = new int[N];
		int sum = 0;
		for(int i=0;i<N;i++)
			number[i] = sc.nextInt();
		
		int[] oper = new int[4];
		for(int i=0;i<4;i++) {
			int tmp  =sc.nextInt();
			oper[i] =tmp;
			sum += tmp;
		}
		select = new int[sum];
		ans = new int[sum];
		v= new boolean[sum];
		int cnt =0;
		for(int i=0;i<oper.length;i++) {
			for(int j=0;j<oper[i];j++) {
				select[cnt++] = i;
			}
		}
	
		
		
		go(0,sum);
		System.out.println(max);
		System.out.println(min);
		
		
	}
}
