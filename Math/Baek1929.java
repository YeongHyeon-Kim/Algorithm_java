package com.Algorithm_java.Math;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//836ms -> 308 ms by rlatjdwo555
public class Baek1929 {
		public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //sout 시간 줄이기 위해서 stringBuffer 사용

		String nm[] = input.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		boolean prime[] = new boolean[m+1];

		for(int i=2; i<=m; i++) {
			if(prime[i]) continue; //발상의 전환 true가 되어있으면 소수가 아니라는 판단
									// 처음에 true로 모두 채워줄 필요가 없음.... 이걸 생각 못했다.

			if(i >= n) sb.append(i+"\n"); // true가 아닌데 기준값 n보다 크면 소수 이므로 string buffer에 추가해줌

			for(int j=i+i; j<=m; j+=i) {
				prime[j] = true; //소수의 배수들 true로 바꿔주기
			}
		}

		System.out.println(sb);
	}
}
