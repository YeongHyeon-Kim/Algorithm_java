package com.Algorithm_java.SAMSUNG.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1713 {
	static int N, K;
	static int[] inputs;
	static Person[] people;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		inputs = new int[K];
		people = new Person[101];

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Person> list = new ArrayList<>();
		for (int k = 0; k < K; k++) {

			int num = Integer.parseInt(st.nextToken());
			if(people[num] == null){
				people[num] = new Person(num, 0, 0, false);
			}

			if(people[num].isIn == true){//사진판에 있는 경우 -> count++
				people[num].count++;
			}else{//사진판에 없는 경우 -> 하나 골라서, 제거 후 새 후보 추가
				if(list.size() == N){
					Collections.sort(list);
					Person p = list.remove(0);
					p.isIn = false;
				}
				people[num].count = 1;
				people[num].isIn = true;
				people[num].timestamp = k;
				list.add(people[num]);
			}

		}
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});
		//정렬 람다 방법
//		Comparator.comparingInt(Person::getNum);
//		Collections.sort(list, Comparator.comparingInt(o->o.num));
		System.out.println();
	}
}

class Person implements Comparable<Person>{
	int num;
	int count;
	int timestamp;
	boolean isIn;

	public int getNum() {
		return num;
	}

	public Person(int num, int count, int timestamp, boolean isIn) {
		this.num = num;
		this.count = count;
		this.timestamp = timestamp;
		this.isIn = isIn;
	}

	@Override
	public String toString() {
		return "Person{" +
				"num=" + num +
				", count=" + count +
				", timestamp=" + timestamp +
				'}';
	}

	@Override
	public int compareTo(Person o) {
		int compare1 = Integer.compare(count, o.count);
		if( compare1 ==0){
			return Integer.compare(timestamp, o.timestamp); //오름차순
		}else{
			return compare1;
		}
	}
}