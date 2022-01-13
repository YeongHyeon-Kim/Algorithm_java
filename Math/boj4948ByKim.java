package com.Algorithm_java.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4948ByKim {
	static int N,count;
	public static void main(String[] args) throws IOException {
		int n = 123456*2;
		boolean [] check = new boolean[n+1];
		for(int i=2; i*i<=n; i++){
			if(!check[i]){
				for(int j=i*i; j<=n; j+=i){
					check[j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			N = Integer.parseInt(br.readLine());
			count = 0;
			if (N==0){
				break;
			}else{
				for(int i =N+1; i<=2*N; i++){
					if(!check[i]){
						count+=1;
					}
				}
				System.out.println(count);
			}
		}
	}
}
