package com.Algorithm_java.SAMSUNG.Day2.boj2003;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M, low, high, sum, count;
	static int[] input;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}

		low = 0;
		high = 0;
		count = 0;
		sum = 0;
		while(true){
			if(low >= high){
				sum = input[low];
				high = low;
			}else{
				sum = 0;
				for (int i = low; i <= high ; i++) {
					sum += input[i];
				}
			}

			if(sum == M){
				count++;
				low++;
			}else if(sum < M){
				high++;
			}else{
				low++;
			}

			if(low==N || high==N){
				break;
			}
		}
		System.out.println(count);

	}
}