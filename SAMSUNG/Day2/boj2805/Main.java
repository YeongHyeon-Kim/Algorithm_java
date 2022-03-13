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
		int high = 0;
		st =  new StringTokenizer(br.readLine());
		for (int i = 0; i <N ; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high,tree[i]);
		}



		int low = 0;

		int sum =0;
		int result = 0;
		int mid = (low + high)/2;
		boolean isMade = false;
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
				isMade = true;
				result = Math.max(mid,result);
				low = mid+1;
			}else{
				if(isMade){
					break;
				}
				high = mid;
			}
			mid = (low + high)/2;

		}
		System.out.println(result);




	}
}
