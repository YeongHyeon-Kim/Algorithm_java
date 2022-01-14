package com.Algorithm_java.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724 {
	static Queue<Integer> que;
	static int N,M, u, v, now, result;
	static StringTokenizer st;
	static int[][] map;
	static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		checked = new boolean[N];
		map = new int[N][N];
		que = new LinkedList<Integer>();
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken())-1;
			v = Integer.parseInt(st.nextToken())-1;
			map[u][v] = 1;
			map[v][u] = 1;
		}
		for(int i=0; i<N; i++){
			if(!checked[i]){
				checked[i] = true;
				BFS(i);
				result++;
			}
		}
		System.out.println(result);

	}

	static void BFS(int start){
		que.add(start);
		while(!que.isEmpty()){
			now = que.poll();
			for(int j=0; j<N; j++){
				if(!checked[j] & map[now][j]==1){
					checked[j] = true;
					que.add(j);
				}
			}

		}
	}
}
