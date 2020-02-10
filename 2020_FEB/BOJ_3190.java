package cheerUp;

import java.util.Scanner;

public class BOJ_3190 {
	static int size;
	static int[] apple;
	static int[][] board;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static class Cmd{
		int time;
		String direction;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		board = new int[size+1][size+1];
		int ap= sc.nextInt();
		for(int i=0;i<ap;i++) {
			int x=sc.nextInt();
			int y = sc.nextInt();
			board[x][y] = -1;
		}
		int cmd = sc.nextInt();
		
		int step=1,len =1;
		int dir = 0;
		int x=1;int y=1;
		
		Cmd[] commend = new Cmd[cmd];
		for(int i=0;i<cmd;i++) {
			commend[i] = new Cmd();
			commend[i].time = sc.nextInt();
			commend[i].direction = sc.next();
		}
		int idx=0;
		while(true) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			
			if(nx<1||nx>size||ny<1||ny>size) break;
			
			if(board[nx][ny] == 0)
			{
				board[nx][ny] = step;
				x=nx;y=ny;
			}else if(board[nx][ny] == -1) {
				len++;
				board[nx][ny] = step;
				x=nx;y=ny;
			}else {
				if(step-board[nx][ny] <=len) break;
				else {
					board[nx][ny] = step;
					x=nx;y=ny;
					}
			}
		
			if(step == commend[idx].time) {
				if(commend[idx].direction.equals("D"))
					dir++;
				else
					dir--;
				
				if(dir>=4)
					dir %=4;
				else if(dir<0)
					dir +=4;
				
				idx++;
				if(idx >=cmd)
					idx=0;
				
			}
			step++;
			
		}
		System.out.println(step);
		
	}

}
