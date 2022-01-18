package com.Algorithm_java.SAMSUNG.Day2.boj2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kash {
	static int N, M, low, high;
	static long T, sum, count;
	static long[] numA, numB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Long.parseLong(br.readLine());


		N = Integer.parseInt(br.readLine());
		numA = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numA[i] = Long.parseLong(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		numB = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < M; n++) {
			numB[n] = Long.parseLong(st.nextToken());
		}

		ArrayList<Long> partA = new ArrayList<>();
		ArrayList<Long> partB = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			sum = numA[i];
			partA.add(sum);
			for (int j = i + 1; j < N; j++) {
				sum += numA[j];
				partA.add(sum);
			}
		}

		for (int i = 0; i < M; i++) {
			sum = numB[i];
			partB.add(sum);
			for (int j = i + 1; j < M; j++) {
				sum += numB[j];
				partB.add(sum);
			}
		}

		Collections.sort(partA);
		Collections.sort(partB, Comparator.reverseOrder());

		long result = 0;
		int ptA = 0;
		int ptB = 0;
		while(ptA < partA.size() && ptB < partB.size()){
			long currentA = partA.get(ptA);
			long target = T - currentA;
			//currentB == target -> subA 같은 수 개수 체크 -> 답구하기. ptA+ ptB+
			if(partB.get(ptB)==target){
				long countA = 0;
				long countB = 0;
				while(ptA < partA.size() && partA.get(ptA) == currentA){
					countA++;
					ptA++;
				}
				while(ptB < partB.size() && partB.get(ptB) == target){
					countB++;
					ptB++;
				}
				result += countA * countB;
			}
			else if(partB.get(ptB) > target) {
				ptB++;
			}else{
				ptA++;
		}

		}
	}

}