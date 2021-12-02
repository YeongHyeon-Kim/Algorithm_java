package com.Algorithm_java.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ByKim 704
public class Baek1260ByKim {
	static int n;
	static int m;
	static int start;

	static int[][] check;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		check = new int[10001][1001];
		checked = new boolean[1001];

		for(int i=0; i < m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			check[x][y] = check[y][x] = 1;
		}
		dfs(start);
		checked = new boolean[1001];
		System.out.println();
		bfs(start);
	}
	public static void dfs(int start){
		checked[start] = true;
		System.out.print(start + " ");
		for(int i = 1; i <= n; i++){
			if(check[start][i] == 1 && !checked[i]){
				dfs(i);
			}
		}
	}

	public static void bfs(int start){
		checked[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		System.out.print(start + " ");
		while(!queue.isEmpty()){
			int temp = queue.poll();
			for(int j = 1; j<=n; j++){
				if(check[temp][j]==1 && !checked[j]){
					checked[j]=true;
					System.out.print(j + " ");
					queue.offer(j);
				}
			}

		}
	}
}

