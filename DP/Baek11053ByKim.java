package com.Algorithm_java.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11053ByKim {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] A = new int[N];
		int result = 0;
		for(int i =0; i<N; i++){
			for(int j =0; j<i; j++){
				if((arr[i]>arr[j])&(A[i]<A[j])){ //현재값이 array의 j번째 값보다 크고, dp array에서 j번째 값(j번째 값까지의 가장 긴 수열)보다 현재 i에 저장된 값보다 크다면 값 교체
					A[i] = A[j];
				}
			}
			A[i] +=1; // 수열이니까 항상 자기 자신을 포함할수있음. 0이 아닌 1, int [] 는 0으로 초기화되기 때문에 처음부터 1을 채우기 위한 for문은 필요 없을거라 판단함.
			result = Math.max(A[i],result); //마지막에 결과 출력에서 max를 찾기 위해서 다시 탐색하는것보다 여기서 하는게 낫다고 판단?..
		}
		System.out.print(result);
	}
}
