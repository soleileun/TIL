package bochungclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
	static int [] count;

	public static void main(String[] args) throws IOException {
		
		//�־��� �����迭�� �Է¹޾Ƽ� ��������Ʈ�� ī��Ʈ �迭�� �����. 
		//ī��Ʈ�� 0�� ������ ť�� �����Ѵ�.
		//������ ����� ���� ī��Ʈ�� ��´�. 
		//���� ī��Ʈ�� 0�̸� �ش� ������ ť�� �����Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N+1;i++) {
			arr.add(new ArrayList<Integer>());
		}
		count = new int[N+1];
		
		for(int i=0;i<M;i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 arr.get(x).add(y);
			// arr.get(y).add(x);
			 count[y] ++;
		}
		Queue<Integer > q = new LinkedList<Integer>();
		for(int i=1;i<N+1;i++) {
			if(count[i] == 0) {
				q.offer(i);	
			sb.append(i).append(" ");
			}
			
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=0;i<arr.get(tmp).size();i++) {
				count[arr.get(tmp).get(i)]--;
				if(count[arr.get(tmp).get(i)] == 0) {
					q.offer(arr.get(tmp).get(i));
					sb.append(arr.get(tmp).get(i)).append(" ");
				}
			}
			
		}
		
		System.out.println(sb);
	}
	
}
