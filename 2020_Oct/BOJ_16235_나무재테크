
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16235_나무재테크 {
	
	static int N,M,Year;
	static int ground[][],SD[][], good[][];
	static Tree[][] forest;
	static Tree[][] dead_forest;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};

	static class Tree {
		ArrayList<Integer> tree;

		public Tree(ArrayList<Integer> tree) {
			super();
			this.tree = tree;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Year = sc.nextInt(); 
		ground = new int [N][N];
		SD = new int [N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				SD[i][j] = sc.nextInt();
				ground[i][j] = 5;
			}
		}
		forest = new Tree[N][N];
		dead_forest = new Tree[N][N];
		good = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				forest[i][j] = new Tree(new ArrayList<>());
				dead_forest[i][j] = new Tree(new ArrayList<>());
			}
		}
		
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			forest[x-1][y-1].tree.add(age);
		}

		for(int y=0;y<Year;y++) {
			
		//Spring 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(forest[i][j].tree.size() != 0) {
					forest[i][j].tree.sort(null);
					ArrayList<Integer> temp = forest[i][j].tree;
					for(int t =0;t<temp.size();) {
						if(ground[i][j]>=temp.get(t)) {
							ground[i][j] -= temp.get(t);
							temp.set(t, temp.get(t)+1);
							t++;
						}else {
								int plus = temp.get(t)/2;
								good[i][j] += plus; 
								temp.remove(t);
						}
					}
					forest[i][j].tree.sort(null);
			}
		}
	}

		//summer
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ground[i][j] += good[i][j];
				good[i][j] = 0;
			}
		}
		

		//autumn
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(forest[i][j].tree.size() !=0) {
					for(int t=0;t<forest[i][j].tree.size();t++) {
						if(forest[i][j].tree.get(t)%5 ==0) {
							for(int dir=0;dir<8;dir++) {
								int nx = i+dx[dir];
								int ny = j+dy[dir];
								if(nx<0||nx>=N||ny<0||ny>=N) continue;
								forest[nx][ny].tree.add(1);
							}
						}
					}
				}
			}
		}
	
		//winter
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ground[i][j] += SD[i][j];
			}
		}
	
		}
		int treeCnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				treeCnt += forest[i][j].tree.size();
			}
		}
		
		System.out.println(treeCnt);
}
}
