package date20200206;

import java.util.Scanner;


public class SWEA_1948 {

	static int day;
	static int search(int m) {
		
		switch (m) {
		case 1: case 3: case 5:
		case 7: case 8:	case 10:
		case 12:
			day = 31;
			break;
		case 2:
			day=28;
			
			break;
		case 4:	case 6:	case 9:	case 11:
			day=30;
			break;
		default:
			break;
		}
		return day;
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		
		
		for(int t=1;t<=tc;t++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
		sb.append("#").append(t).append(" ");

			int sum=0;
			
			if(m1 != m2) {
				
				for(int i=d1+1;i<=search(m1);i++)
					sum++;
				
				for(int i=m1+1;i<m2;i++) {
					sum += search(i);
				}
				
				for(int i=0;i<=d2;i++)
					sum++;
				
				
			}else {
				for(int i=d1;i<=d2;i++)
					sum++;
			}
			
			
			
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}

}
