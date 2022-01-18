package com.Algorithm_java.SAMSUNG.Day2.boj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, low, high, sum, length, result;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		boolean isMade = false;
		low = 0;
		high = 0;
		sum = nums[0];
		length = 1;
		result = 0;
		while (true) {
			//sum >= M --> length가 result 더 작으면 result 갱신,
			if (sum >= M) {
				if (result == 0 || length < result) {
					result = length;
				}
				sum -= nums[low++];
				length--;
			} else {//sum<M --> length ++, high++
				sum += nums[++high];
				length++;
			}
			if (high == N) {
				break;
			}
		}
		System.out.println(result);
	}
}

