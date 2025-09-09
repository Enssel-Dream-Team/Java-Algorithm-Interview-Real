package seonguk.x03array;

import java.util.Scanner;

public class P10808 {
	public static void main(String[] args) {
		int[] arr = new int[26];

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		for(char c : str.toCharArray()) {
			arr[c - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb.toString());

		scan.close();
	}
}
