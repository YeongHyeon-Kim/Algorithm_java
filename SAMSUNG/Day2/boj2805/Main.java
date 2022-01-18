package com.Algorithm_java.SAMSUNG.Day2.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];

		st =  new StringTokenizer(br.readLine());
		for (int i = 0; i <N ; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tree);

		int low = 0;
		int high = tree[N-1];
		int sum =0;
		int result = 0;
		int mid = (low + high)/2;
		while(low<=mid){
			sum =0;
			for (int i = 0; i <N ; i++) {

				if(tree[i]>mid){
					sum += tree[i] - mid;
				}
			}

			if (sum == M){
				result = mid;
				break;
			}else if(sum > M){
				result = Math.max(mid,result);
				low = mid+1;
			}else{
				high = mid;
			}
			mid = (low + high)/2;

		}
		System.out.println(result);




	}
}
