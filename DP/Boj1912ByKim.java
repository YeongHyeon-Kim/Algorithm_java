package com.Algorithm_java.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1912ByKim {
	static int result, N;
	static StringTokenizer st;
	static int[] arr, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr  = new int[N];
		res = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		res[0] = arr[0];
		for(int i=1; i<N; i++){
			int sumV = res[i-1] + arr[i];
			if (arr[i] <= sumV){
				res[i] = sumV;
			}else{
				res[i] = arr[i];
			}
		}
		result = Integer.MIN_VALUE;
		for(int i=0; i<N; i++){
			if(result<res[i]){
				result = res[i];
			}
		}
		System.out.println(result);

//      for문 3가지를 1개로 합친 코드 / 시간이 줄어들줄 알았는데 오히려 더 늘어났다,., 왜지?
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		arr  = new int[N];
//		res = new int[N];
//		st = new StringTokenizer(br.readLine());
//		result = Integer.MIN_VALUE;
//		for(int i=0; i<N; i++){
//			arr[i] = Integer.parseInt(st.nextToken());
//			res[i] = arr[i];
//			if(i !=0){
//				int sumV = res[i-1] + arr[i];
//				if (arr[i] <= sumV) {
//					res[i] = sumV;
//				}
//			}
//			if(result<res[i]){
//				result = res[i];
//			}
//		}
//
//
//		System.out.println(result);


	}


}
