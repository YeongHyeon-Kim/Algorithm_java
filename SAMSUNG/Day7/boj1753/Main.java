package com.Algorithm_java.SAMSUNG.Day7.boj1753;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class info implements Comparable<info>{
		int node;
		int distance;

		public info(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}

		@Override
		public int compareTo(info o) {
			return Integer.compare(distance, o.distance);
		}
	}

	static int V,E;
	static ArrayList<info>[] Map;
	static int [] Distance;
	static int Start;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		Map = new ArrayList[V+1];
		Distance = new int[V+1];
		for(int i = 1 ; i<= V ; i++) {
			Map[i] = new ArrayList<>();
			Distance[i] = INF;
		}

		Start = Integer.parseInt(br.readLine());

		int u, v, w;
		for(int i = 1 ; i <= E ;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			Map[u].add(new info(v, w)); // 단방향이기 때문에 하나만 넣는다. 아니면 양쪽으로 둘다 넣어야함
		}

		findShortestPath(Start);

		for(int i = 1 ; i<= V ; i++) {
			if(Distance[i] != INF) {
				bw.write(Distance[i] + "\n");
			} else {
				bw.write("INF" + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

	private static void findShortestPath(int start) {
		PriorityQueue<info> pq = new PriorityQueue<>();
		Distance[start] = 0;
		pq.add(new info(start, 0));
		while(!pq.isEmpty()){
			info now = pq.poll();
			if(now.distance > Distance[now.node]){
				continue;
			}
			for(info next : Map[now.node]){
				if(Distance[next.node] > Distance[now.node]+ next.distance){
					Distance[next.node] = Distance[now.node]+ next.distance;
					pq.add(new info(next.node, Distance[next.node]));
				}
			}
		}
	}
}
