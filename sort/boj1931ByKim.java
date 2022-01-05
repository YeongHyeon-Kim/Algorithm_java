package com.Algorithm_java.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931ByKim {
	static int N;
	static StringTokenizer st;
	static int end_time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for(int i =0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//					return o1[0] - o2[0];
//			}
//		});
//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[1] - o2[1];
//			}
//		});

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		int result = 0;
		end_time = 0;
		for(int[] a  : arr){
			if(end_time <= a[0]){
				end_time = a[1];
				result +=1;
			}
		}
		System.out.print(result);

	}
}

