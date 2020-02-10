package day9;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import day9.BST.Node;

public class SWEA_1231 {
	
	
	public static class Node{
		int v;
		Node l,r;
		public Node(int v) {
			super();
			this.v = v;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[" + v +" - (")
					.append(l == null?"n":l.v).append(",").append(r == null?"n":r.v).append(")]");
			return sb.toString();
		}


	}

	public static Node root;
	static String[] word ;	
	static 	StringBuilder sb = new StringBuilder();
	public static void InOrder(Node node) {
		if(node == null) return;
		
		InOrder(node.l);
		sb.append(word[node.v]);
		InOrder(node.r);
	}
	private static Node[] tree;
	
	private static Node getNode(int idx) {
		//Node node = tree[idx];
		if(tree[idx] == null) {
			tree[idx] = new Node(idx);
		}
		return tree[idx];
	}
		
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			sb.append("#").append(t).append(" ");
			int sidx =1;
			int size = sc.nextInt();
			tree = new Node[size+1];
			word = new String[size+1];
		
			for(int i=1;i<=size/2;i++) {
				
				
				if(size%2 ==0 && i == size/2) {
				
					int p = sc.nextInt();
					word[sidx++] = sc.next();
					int c1 = sc.nextInt();
				
					Node pNode = getNode(p);
					Node c1Node = getNode(c1);
				
					pNode.l = c1Node;
					
					
					break;
				}
				//if(i == size/2) break;
				
				int p = sc.nextInt();
				word[sidx++] = sc.next();
				int c1 = sc.nextInt();
				int c2 = sc.nextInt();
				Node pNode = getNode(p);
				Node c1Node = getNode(c1);
				Node c2Node = getNode(c2);
				pNode.l = c1Node;
				pNode.r = c2Node;
				

				
			}
			for(int i=size/2+1;i<=size;i++) {
				int tmp  =sc.nextInt();
				word[sidx++] = sc.next();
			}
			//여기까지 입력완료..
			
			//System.out.println(Arrays.toString(tree));	
			InOrder(tree[1]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
