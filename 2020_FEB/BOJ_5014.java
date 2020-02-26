package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	
	static class Stair{
		int x;
		int step;
		public Stair(int x, int step) {
			super();
			this.x = x;
			this.step = step;
		}
		
	}

	static int F,S,G,U,D;
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // �� �ǹ��� ����
		S = Integer.parseInt(st.nextToken()); // ��ȣ�� �ִ� ��
		G = Integer.parseInt(st.nextToken()); // ��ŸƮ��ũ ��ġ 
		U = Integer.parseInt(st.nextToken()); // �ö� �� �ִ� ��ư
		D = Integer.parseInt(st.nextToken()); // ������ �� �ִ� ��ư 
		
		boolean[] visit  = new boolean[1000007];
	
		Queue<Stair> q= new LinkedList<>();
		
		q.offer(new Stair(S,0));
		visit[S] = true;
		int ans=-1;
		//boolean arrive = false;
		while(!q.isEmpty()) {
			Stair tmp = q.poll();
			
			if(tmp.x == G)
			{
				ans = tmp.step;
				break;
			}
			
			if(tmp.x+U<=F)
				{
				if(visit[tmp.x+U] == false) {
					visit[tmp.x+U] = true;
					q.offer(new Stair(tmp.x+U,tmp.step+1));
				}
				}
			
			if(tmp.x-D >= 1)
			{
			if(visit[tmp.x-D] == false) {
				visit[tmp.x-D] = true;
				q.offer(new Stair(tmp.x-D,tmp.step+1));
			}
			}
			
			
			
		}
		
		
		
		if(ans == -1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
		
	}

}
