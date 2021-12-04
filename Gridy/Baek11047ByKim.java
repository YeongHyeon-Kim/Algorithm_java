package com.Algorithm_java.Gridy;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

//124ms
public class Baek11047ByKim {
	static int N, K;
	static int[] coin;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coin = new int[N];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}

		int i = N-1;
		int result = 0;
		while(K!=0){
			if(coin[i] <= K){
				int div = K/coin[i];
				result += div;
				K -= div*coin[i];
			}
			i--;
		}
		System.out.println(result);
	}

}
