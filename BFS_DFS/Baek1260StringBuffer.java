package com.Algorithm_java.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// ByKim 704 -> Sout 360 -> StringBuffer 244
public class Baek1260StringBuffer {
	static int N, M, V, s, e;

	static ArrayList<Integer>[] list;
	static boolean visit[];
	static StringBuilder sb;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];

		que = new LinkedList<>();

		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		for(int i = 1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		visit = new boolean[N+1];
		sb = new StringBuilder();
		dfs(V,sb);
		System.out.println(sb.toString());
		visit = new boolean[N+1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb.toString());
	}
	public static void dfs(int start, StringBuilder sb){
		visit[start] = true;
		sb.append(start).append(" ");
		for(int i = 0; i < list[start].size(); i++){
			int next = list[start].get(i);
			if(!visit[next]){
				dfs(next,sb);
			}
		}
	}

	public static void bfs(int start){
		visit[start] = true;
		que.add(start); // add - 예외 발생
//        queue.offer(start); - 없으면 false return
		while(!que.isEmpty()){
			int temp = que.poll();
//	        System.out.print(temp + " ");
			sb.append(temp).append(" ");
			for(int j = 0; j<list[temp].size(); j++){
				int next = list[temp].get(j);
				if(!visit[next]) {
					que.add(next);
					visit[next] = true;
				}
			}
		}
	}
}

