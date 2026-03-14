package seonguk.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P01138 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		List<Person> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		for (int i = 0; i < N; i++) {
			int leftCnt = Integer.parseInt(st.nextToken());
			list.add(new Person(i + 1, leftCnt));
		}

		List<Person> result = new ArrayList<>();
		while (!list.isEmpty()) {
			for (Person p : list) {
				if (check(result, p)) {
					result.add(p);
					list.remove(p);
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Person p : result) {
			sb.append(p.tall).append(" ");
		}

		System.out.println(sb);
	}

	private static boolean check(List<Person> result, Person person) {
		int cnt = 0;
		for (Person comp : result) {
			if (comp.tall > person.tall) {
				cnt++;
			}
		}
		return cnt == person.leftCnt;
	}

	static class Person {
		int tall;
		int leftCnt;

		public Person(int tall, int leftCnt) {
			this.tall = tall;
			this.leftCnt = leftCnt;
		}
	}
}
