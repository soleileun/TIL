import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	
	static int[][] board;
	static boolean[][] visit;
	static Point[][] map;
	static int N,M;
	static ArrayList<Edge> edge = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int getParent(int[] set, int x) {
		if(set[x] == x) return x;
		return set[x] = getParent(set, set[x]);
	}
	
	static void unionParent(int[] set, int a, int b) {
		a=getParent(set, a);
		b= getParent(set, b);
		if(a<b) set[b] =a;
		else set[a]=b;
	}
	
	static int find(int set[], int a, int b) {
		a = getParent(set, a);
		b= getParent(set, b);
		if(a == b) return 1;
		else return 0;
	}
	
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int len;
		
		public Edge(int start, int end, int len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", len=" + len + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if(this.len > o.len)
				return 1;
			else if(this.len< o.len) {
				return -1;
			}
			return 0;
		}
		
		
		
	}
	
	static class Point{
		int x;
		int y;
		boolean possible;
		public Point(int x, int y, boolean possible) {
			super();
			this.x = x;
			this.y = y;
			this.possible = possible;
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board=new int[N][M];
		visit=new boolean[N][M];
		map = new Point[N][M];
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visit[i][j]) continue;
				if(board[i][j] == 1) {
					count++;
					q.offer(new Point(i,j,false));
					visit[i][j] = true;
					while(!q.isEmpty()) {
						Point tmp = q.poll();
						board[tmp.x][tmp.y] = count;
						for(int dir =0;dir<4;dir++) {
							int nx = tmp.x+dx[dir];
							int ny = tmp.y+dy[dir];
							
							if(nx<0||nx>=N||ny<0||ny>=M) continue;
							if(visit[nx][ny] || board[nx][ny]==0) continue;
							
							q.offer(new Point(nx,ny,false));
							visit[nx][ny] = true;
						}
					}
					
				}
			}
		}
//		System.out.println("check1");
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				boolean flag = false;
				for(int dir=0;dir<4;dir++) {
					int nx = i+dx[dir];
					int ny = j+dy[dir];
					
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(board[i][j] != 0 && board[nx][ny] == 0)
						flag= true;
				}
				if(flag)
					map[i][j] = new Point(i,j,true);
				else
					map[i][j] = new Point(i,j,false);
			}
		}
//		System.out.println("check2");
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(board[i][j] + " ");
//			}System.out.println();
//		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j].possible) {			
					for(int dir=0;dir<4;dir++) {
						int cnt =0;
						int x = i ; int y = j ;
						while(true) {
							int nx = x+dx[dir];
							int ny = y+dy[dir];
							
							if(nx<0||nx>=N||ny<0||ny>=M) break;
							if(board[nx][ny] ==0 ) {cnt ++; x=nx;y=ny;continue;}
							if(board[nx][ny] != board[i][j]) {
								
								if(cnt>=2) {
									if(board[i][j] < board[nx][ny])
										edge.add(new Edge(board[i][j], board[nx][ny], cnt));
									else
										edge.add(new Edge(board[nx][ny], board[i][j], cnt));
										
								}
								break;
							}else {
								break;
							}
						}
					}
				}
			}
		}
		
	
		
		edge.sort(null);
		ArrayList<Edge> test = new ArrayList<>();
		int sum =0;
		int[] edge_set = new int[10];
		for(int i=0;i<count;i++){
			edge_set[i] = i;
		}
		for(int i=0;i<edge.size();i++) {
			//System.out.println("여긴..?");
			if(find(edge_set,edge.get(i).start-1,edge.get(i).end-1) != 1) {
				sum += edge.get(i).len;
				test.add(edge.get(i));
				
				unionParent(edge_set, edge.get(i).start-1, edge.get(i).end-1);
			}
		}
		
		test.sort(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.start >o2.start)
					return 1;
				else if( o1.start == o2.start)
				{
					if(o1.end >  o2.end)
						return 1;
				}
					return -1;
			}
			
		});
		for(int i=0;i<test.size();i++) {
			unionParent(edge_set, test.get(i).start-1, test.get(i).end-1);			
		}

		
	boolean flag = false;
	for(int i=0;i<edge_set.length;i++) {
		if(edge_set[0] == edge_set[i])
			continue;
		else
			flag=true;
	}
	if(flag)
		System.out.println("-1");
	else
		System.out.println(sum);
	
	}

}
