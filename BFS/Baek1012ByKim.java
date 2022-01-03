package com.Algorithm_java.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012ByKim {static int T, M, N, K,cab_x,cab_y, result;
	static Queue<int[]> que;

	static boolean[][] checked,cabbage;
	static int[] X = {1,-1,0,0};
	static int[] Y = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			que = new LinkedList<int[]>();
			checked = new boolean[N][M];
			cabbage = new boolean[N][M];

			for(int k=0; k<K; k++){
				st = new StringTokenizer(br.readLine());
				cab_x = Integer.parseInt(st.nextToken());
				cab_y = Integer.parseInt(st.nextToken());
				cabbage[cab_y][cab_x] = true;
			}
			result = 0;
			for(int y=0; y<N; y++){
				for(int x=0; x<M; x++){
					if(cabbage[y][x] & !checked[y][x]){
						checked[y][x] = true;
						BFS(new int[] {x,y});
						result+=1;
					}

				}
			}
			System.out.println(result);
		}
	}
	static void BFS(int[] input){
		que.add(input);
		while(!que.isEmpty()){
			int[] cab = que.poll();
			int tmp_x = cab[0];
			int tmp_y = cab[1];
			for(int i =0; i<4; i++){
				int new_x = tmp_x + X[i];
				int new_y = tmp_y + Y[i];
				if((0<=new_x)&(new_x<M)&(0<=new_y)&(new_y<N)){
					if((!checked[new_y][new_x])&(cabbage[new_y][new_x])){
						checked[new_y][new_x] = true;
						que.add(new int [] {new_x, new_y});
					}
				}
			}
		}
	}
}