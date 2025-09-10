package seonguk.x03array;

import java.util.Scanner;

public class P01919 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();

		int[] arr1 = count(str1);
		int[] arr2 = count(str2);

		int ans = 0;
		for(int i = 0; i < 26; i++) {
			ans += Math.abs(arr1[i] - arr2[i]);
		}

		System.out.println(ans);

		scan.close();
	}

	static int[] count(String str) {
		int[] arr = new int[26];

		for(char c : str.toCharArray()) {
			arr[c - 'a']++;
		}
		return arr;
	}
}
