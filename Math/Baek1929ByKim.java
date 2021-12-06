package com.Algorithm_java.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//836ms
public class Baek1929ByKim {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[M+1];
		Arrays.fill(check,true); //전체를 true로 채움
		check[1] = false; //바로 밑 for문 에서는 상관없지만 출력때 1이 출력될수도 있으니 false로 변환

		for(int i=2; i*i<=M; i++){
			if(check[i]){//true일때
				for(int j = i*i; j<=M; j+=i){//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
					check[j]=false; //소수가 아닌것들은 모두 false로 바꿔주기
				}
			}
		}
		for(int i=N; i<=M; i++){
			if(check[i]){ //true일때만 출력
				System.out.println(i);
			}
		}
	}

}
