package date20200217;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471 {

	static int N;
	static int[] arr;
	static int[] people;	
	static boolean ans =false;
	static ArrayList<ArrayList<Integer>> map;
	static int min = Integer.MAX_VALUE;
	static boolean check = false;
	
	
	static void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	static int possible(int arr[]) {
		
		
		boolean[] allcheck = new boolean[N];
		boolean[] visit = new boolean[N];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(arr[0]);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0;i<map.get(tmp).size();i++) {
				 {
					for(int k=0;k<arr.length;k++) {
						if(map.get(tmp).get(i) == arr[k]) {
							if(visit[map.get(tmp).get(i)] == false) {
							visit[map.get(tmp).get(i)] = true;
							allcheck[map.get(tmp).get(i)] = true;
							q.offer(map.get(tmp).get(i));
							}
						}else {
							continue;
						}
					}
				}
			}
			
		}
		boolean flag = true;
		for(int i=0;i<arr.length;i++) {
			if(visit[arr[i]]) continue;
			else {
				flag = false;
				break;
			}
		}
		
		if(arr.length == N ) {
			for(int i=0;i<allcheck.length;i++) {
				if(allcheck[i])continue;
				else {
					flag=false;
					break;
				}
			}
			
			if(flag)
				return -1;
		}
		// 선택된 구간이 이어져있다면 flag= true; 아니라면 false
		if(flag == false)
			return -1;
		
		boolean[] all = new boolean[N];
		for(int i=0;i<arr.length;i++) {
			all[arr[i]] =true;
		}
		int[] other = new int[N-arr.length];
		int idx=0;
		for(int i=0;i<N;i++) {
			if(all[i] ==true)continue;
			else
				other[idx++] = i;
		}
		
		q = new LinkedList<Integer>();
		visit = new boolean[N];
		q.offer(other[0]);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0;i<map.get(tmp).size();i++) {
				if(visit[map.get(tmp).get(i)] == false) {
					//큐에 넣을때 other의 원소인지 확인하고 넣겠다는 것
					for(int k=0;k<other.length;k++) {
						if(map.get(tmp).get(i) == other[k]) {
							visit[map.get(tmp).get(i)] = true;
							allcheck[map.get(tmp).get(i)] = true;							
							q.offer(map.get(tmp).get(i));
						}else {
							continue;
						}
					}
				
				}
			}
			
		}
		
		//boolean flag = true;
		for(int i=0;i<other.length;i++) {
			if(visit[other[i]]) continue;
			else {
				flag = false;
				break;
			}
		}
		
		for(int i=0;i<allcheck.length;i++) {
			if(allcheck[i])continue;
			else {
				flag=false;
				break;
			}
		}
		
		int result =-1;
		
		if(flag) {
			check = true;
			int sum_select =0;
			int sum_unselect =0;
			for(int i=0;i<arr.length;i++) 
				sum_select += people[arr[i]];
			for(int i=0;i<other.length;i++)
				sum_unselect +=people[other[i]];
			result = sum_select -sum_unselect;
			if(result<0)
				result *=-1;
			
			if(min >result)
				min = result;
			
			return result;
		}else {
			return -1;
		}
		
	}
	static void go(int idx ,int target, int before) {
		if(idx == target) {

			//0. 오름차순으로 뽑아버림
			//1. 내가 뽑은 것들이 이어져있는지 확인해야됨 
			//2. 그룹이 2개가 아니라면 return -1
			//3. 그룹이 2개이고 이어져있다면 인구수 차이확인
			int p = possible(arr);

		}else
		{
			for(int i=before;i<N;i++) {
				arr[idx] = i;
				go(idx+1,target,i+1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N];
		map = new ArrayList<ArrayList<Integer>>();

		for(int i=0;i<N;i++) {  
			people[i] = sc.nextInt();
			map.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N;i++) {
			int tmp = sc.nextInt();
			for(int j=0;j<tmp;j++) {
				int in = sc.nextInt()-1;
				map.get(i).add(in);
				map.get(in).add(i);
				
			}
		}
		for(int i=0;i<N;i++) {
			map.get(i).add(i);
		}
		
		for(int i=1;i<=N;i++) {
			arr = new int[i];
			go(0, i,0);
			
		}
		
		if(check)
			System.out.println(min);
		else
			System.out.println("-1");
			
	
	}

}