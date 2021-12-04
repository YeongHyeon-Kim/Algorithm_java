package com.Algorithm_java.Gridy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

//124ms 1등이 68ms여서 바꿔보았는데 똑같음 자바 버전에 따라 시간이 다른듯
// % 연산과 /연산을 통해서 while문을 for문으로 바꿨고 if문이 바뀌었음
public class Baek11047Bywjsalsrb {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		List<Integer> coin = new ArrayList<>();

		for(int i=0; i<N; i++){
			coin.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		for(int i=N-1; i>=0; i--){
			int now = coin.get(i);
			result += K / now; //만약 코인값이 목표값보다 크면 result는 0으로 결과에 영향을 끼치지 않음, 파이썬의 //과 똑같음

			if(K % now ==0){
				break; //남은 돈이 없을때 / 남은돈이 있으면 어떻게든 %연산 후 값이 남아야함 / 딱 떨어지지 않는다는 뜻
			}else{
				K %= coin.get(i); // % 연산을 통해서 현재 코인으로 채울수 있는돈을 다 채워버림 전혀 생각하지 못했던 방법이였다.
			}
		}
		System.out.println(result);
	}

}
