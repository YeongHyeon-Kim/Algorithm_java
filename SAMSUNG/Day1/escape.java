package com.Algorithm_java.SAMSUNG.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class escape {
	static char[][] jido;
	static Queue<int[]> que;
	static int[][] check;
	static int R,C;
	static int[] start, home;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		que = new LinkedList<int[]>();
		jido = new char[R][C];
		check = new int[R][C];
		start = new int[3];
		home = new int[2];

		for(int i =0; i<R; i++){
			char[] a = br.readLine().toCharArray();
			for(int j=0; j<C; j++){
				char tmp = a[j];
				jido[i][j] = tmp;
				if (tmp == 'S'){
					start[0] = i;
					start[1] = j;
					start[2] = -1;
				}else if(tmp =='D'){
					home[0] = i;
					home[1] = j;
				}else if(tmp == '*'){
					que.add(new int[]{i,j,-2});
				}
			}
		}
		que.add(start);
		BFS();
		if (check[home[0]][home[1]] == 0){
			System.out.println("KAKTUS");
		}else{
			System.out.println(check[home[0]][home[1]]);
		}

	}
	public static void BFS(){
		while(!que.isEmpty()){
			int[] now = que.poll();
			int now_y = now[0];
			int now_x = now[1];
			int status = now[2];
			int day = check[now_y][now_x];

			if(status==-2){
				for(int i=0; i<4; i++){
					int new_y = now_y + dy[i];
					int new_x = now_x + dx[i];
					if((0<=new_y)&&(new_y<R)&&(0<=new_x)&&(new_x<C)){
						if(jido[new_y][new_x] == '.'){
							que.add(new int[]{new_y,new_x,-2});
							jido[new_y][new_x] = '*';
						}
					}
				}
			}else if(status==-1){
				for(int i=0; i<4; i++){
					int new_y = now_y + dy[i];
					int new_x = now_x + dx[i];
					if((0<=new_y)&&(new_y<R)&&(0<=new_x)&&(new_x<C) && jido[new_y][new_x] != '*' && check[new_y][new_x] == 0){
						if(jido[new_y][new_x] == '.'){
							que.add(new int[]{new_y,new_x,-1});
							check[new_y][new_x] = day+1;
						}else if (jido[new_y][new_x] == 'D'){
							check[new_y][new_x] = day+1;
							return;
						}
					}
				}
			}

		}
	}
}
