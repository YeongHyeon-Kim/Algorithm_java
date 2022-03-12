package com.Algorithm_java.SAMSUNG_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj1713_re {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Person[] people = new Person[101];
		List<Person> list = new ArrayList<>();
		for(int i=0; i<K; i++){
			int num = Integer.parseInt(st.nextToken());
			if(people[num] == null){
				people[num] = new Person(num, 0, 0, false);
			}

			if(people[num].isIn){
				people[num].count++;
			}else{
				if(list.size() == N){
					Collections.sort(list);
					Person p = list.remove(0);
					p.isIn = false;
					p.count = 0;
					people[p.num] = p;
				}
				people[num].count = 1;
				people[num].isIn = true;
				people[num].timeStamp = i;
				list.add(people[num]);
			}
		}
		Collections.sort(list, Comparator.comparingInt(o->o.num));
		for(Person p : list){
			System.out.print(p.num + " ");
		}

	}

}

class Person implements Comparable<Person>{
	int num;
	int count;
	int timeStamp;
	boolean isIn;

	public Person(int num, int count, int timeStamp, boolean isIn) {
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
		this.isIn = isIn;
	}

	public int getNum() {
		return num;
	}

	@Override
	public int compareTo(Person o) {
		int compare1 = Integer.compare(count, o.count); // 0은 같은거, -1은 앞에가 작은거 1은 뒤에가 큰거
		if(compare1==0){
			return Integer.compare(timeStamp, o.timeStamp);
		}else{
			return compare1;
		}
	}
}
