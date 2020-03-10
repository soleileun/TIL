package coffeontheplan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107 {

	static int N,M,ans,destination;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit = new boolean [10];
	static ArrayList<Integer> src = new ArrayList<Integer>();
	static int[] arr;
	static void go(int idx, int target) {
		if(idx ==  target) {
			//System.out.println(Arrays.toString(arr));
			int result = makeNumber(arr);
			int temp = Math.abs(result - destination) + arr.length;
			if(temp<min)
			{	
				System.out.println("¾Æ¿Ö"+Arrays.toString(arr));
				System.out.println(result + " " + destination + " " + temp);
					
				min = temp;
				
			
			}
			
		}
		else {
			for(int i=0;i<src.size();i++) {
				arr[idx] = src.get(i);
				go(idx+1, target);
			}
		}
	}
	
	static int makeNumber(int[] array) {
		int multi =1;
		int sum =0;
		for(int i=array.length-1;i>=0;i--) {
			sum += array[i]*multi;
			multi *=10;
		}
		return sum;
		
	}
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		destination = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int iter = Integer.parseInt(st.nextToken());
		
		
		if(destination  == 100)
		{
			System.out.println("0");
			return;
		}
		int t = destination;
		int cnt =1;
		while(t!=0) {
			if(t/10 !=0) {
				cnt++;
				
			}
			t /=10;
		}
		//System.out.println(cnt);
		if(iter ==10) {
			System.out.println(Math.abs(100-destination));
			return;
		}
		
		if( iter !=0) {
			st = new StringTokenizer(br.readLine());
		for(int it=0;it<iter;it++)
		{
			
			int tmp = Integer.parseInt(st.nextToken());
			visit[tmp] = true;
		}
		}
		
		for(int i=0;i<10;i++) {
			if(visit[i])
				continue;
			else
				src.add(i);		
		}
		
		for(int i=1;i<=cnt+2;i++) {
			arr = new int[i];
			go(0,i);
		}
		
		
//		if(src.size() == 0 || src.get(0) == 0)
//			min = Math.abs(destination - 100);
		if(min > Math.abs(destination - 100))
		{
			min = Math.abs(destination - 100);
		}
			
			
			System.out.println(min);
		
		
		
	}

}
