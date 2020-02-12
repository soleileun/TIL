package cheerUp;

import java.util.Scanner;

public class BOJ_13300 {

	static class Student{
		
		int x=0;
		int y=0;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Student[] st = new Student[6];
		for(int i=0;i<st.length;i++)
			st[i] = new Student();
		for(int i=0;i<n;i++) {
			
			int t2 = sc.nextInt();
			int t1 = sc.nextInt();
			if(t2 ==0)
				st[t1-1].x++;
			else
				st[t1-1].y++;
			
		}
		int sum=0;
		for(int i=0;i<6;i++) {
			int t1 = st[i].x;
			int t2 = st[i].y;
			
			if(t1%k == 0)
				sum +=t1/k;
			else
				sum+=t1/k+1;
			
			
			if(t2%k == 0)
				sum +=t2/k;
			else
				sum+=t2/k+1;
			
			
			
		}
		System.out.println(sum);
		
	}

}
