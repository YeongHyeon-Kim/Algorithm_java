package com.Algorithm_java.SAMSUNG.Day3.boj2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,s,a;
	static long[] nums,trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		s = 1;
		while(s<=N){
			s *=2;
		}
		nums = new long[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}

		topDownInit();

		for (int i = 0; i <M+K ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1){
				long c = Long.parseLong(st.nextToken());
				update(b,c);
			}else{
				int c = Integer.parseInt(st.nextToken());
				query(b,c);
			}

		}

	}

	public static void topDownInit(){
		trees = new long[s*2];
		for (int i = 0; i < N; i++) {
			trees[s+i] = nums[i];
		}

		for (int i = s-1; i > 0; i--) {
			trees[i] = trees[i*2] + trees[i*2+1];
		}
	}

	public static void update(int target, long value){
		int node = s + target - 1;
		trees[node] = value;
		node /=2;
		while(node>=1){
			trees[node] = trees[node*2] + trees[node*2+1];
			node/=2;
		}
	}

	public static void query(int leftQuery, int rightQuery){
		int left = leftQuery + s -1;
		int right = rightQuery + s - 1;
		long result = 0;
		while(left<=right){
			if(left %2 ==1){
				result += trees[left];
				left ++;
			}
			if(right %2 == 0){
				result += trees[right];
				right --;
			}
			left /=2;
			right /=2;
		}
		System.out.println(result);
	}
}
