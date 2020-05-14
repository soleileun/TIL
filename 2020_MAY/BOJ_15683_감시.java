import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.naming.directory.DirContext;

public class BOJ_15683_감시 {
	
	static int N,M;
	static int min = Integer.MAX_VALUE;
	static int[][] board,copy;
	static int[] src,arr,darr;
	static boolean visit[];
	static int[] dir= {0,1,2,3};
	static boolean dvisit[];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Camera> cmr;
	
	static class Camera{
		int x;
		int y;
		int type;
		int dir;
		public Camera(int x, int y, int type, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	cmr = new ArrayList<>();
	
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	board = new int[N][M];
	for(int i=0;i<N;i++) {
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<M;j++) {
			board[i][j] = Integer.parseInt(st.nextToken());
			if(board[i][j] != 0 && board[i][j] !=6)
				cmr.add(new Camera(i,j,board[i][j],0));
		}
	}
		//camera의 위치를 알고있음. 
	src = new int[cmr.size()];
	for(int i=0;i<cmr.size();i++) {
		src[i] = i;
	}
	
	
		visit = new boolean[cmr.size()];
		arr = new int[cmr.size()];
		go(0,cmr.size());
		
	System.out.println(min);
	
	}

	private static void go(int idx,int target) {
		if(idx == target) {
			//몇개를 고를때 어떤 카메라 방향을 바꿀건지가 나옴
			//System.out.println(Arrays.toString(arr));
			//얘네 방향을 어케할거냐
			checkArea(arr);
		
		}else {
			for(int i=0;i<dir.length;i++) {
					arr[idx] = dir[i];
					//visit[i] = true;
					go(idx+1,target);
					//visit[i] = false;
				}
			}
		
	}
	
	static void watch(int[][] map, int x, int y, int dr) {
		while(true) {
			int nx = x+dx[dr];
			int ny = y+dy[dr];
			if(nx <0||nx>=N||ny<0||ny>=M) break;
			if(board[nx][ny] == 6) {copy[nx][ny]=9;break;}
			if(board[nx][ny] == 0)
			{copy[nx][ny] = 9;
			x=nx;y=ny;}
			else {
				x=nx;y=ny;
			}
	}
	}

	
	static void checkArea(int[] arr) {
		copy = new int[N][M];
		
		for(int i=0;i<arr.length;i++) {
			Camera tmp = cmr.get(i);
			if(tmp.type == 1) {
				int x = tmp.x; int y = tmp.y;
				copy[x][y] = tmp.type;
				watch(copy,x,y,arr[i]);
			}else if(tmp.type ==2) {
				int x=tmp.x;int y = tmp.y;
				if(arr[i] %2 ==0) {
					copy[x][y] = tmp.type;
					watch(copy,x,y,1);
					watch(copy,x,y,3);
				}else {
					copy[x][y] = tmp.type;
					watch(copy,x,y,0);
					watch(copy,x,y,2);
				}
				
			}else if(tmp.type==3) {
				int[] direction = new int[2];
				int x=tmp.x;int y = tmp.y;
				copy[x][y] = tmp.type;
				for(int l=0;l<direction.length;l++) 
						direction[l] = (l+arr[i])%4;
				//System.out.println(Arrays.toString(direction));
				for(int l=0;l<direction.length;l++)
					watch(copy, x, y, direction[l]);
				
			}else if(tmp.type ==4) {
				
				int[] direction = new int[3];
				int x=tmp.x;int y = tmp.y;
				copy[x][y] = tmp.type;
				for(int l=0;l<direction.length;l++) 
						direction[l] = (l+arr[i])%4;
				
				for(int l=0;l<direction.length;l++)
					watch(copy, x, y, direction[l]);
				
				//System.out.println(Arrays.toString(direction));
				
			}else if(tmp.type ==5) {
				int x=tmp.x;int y = tmp.y;
				copy[x][y] = tmp.type;
				for(int l=0;l<4;l++) {
					watch(copy, x, y, l);
				}
			}
		}
		int count =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 6) continue;
				
				if(copy[i][j] == 0) count++;
			}
		}
		
		//System.out.println( count );
		if(count<min)
			min = count;
		
		
	}
	
 
}
