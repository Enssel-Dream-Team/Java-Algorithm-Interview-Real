package sehyuk.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 344. Reverse String
 * Link : https://leetcode.com/problems/reverse-string
 * explanation : 투 포인터 이용
 * 2. 시작과 끝 쪽에서 포인터를 만든다.
 * 3. 시작과 끝 포인터 값을 스왑한다.
 * 4. 시작과 끝 포인터 위치를 한 칸씩 이동시킨다.
 * 5. 3~4 과정을 반복한다.
 *
 */
public class LeetCode_344_ReverseString {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		reverseString(input.toCharArray());
	}
	public static void reverseString(char[] s) {
		int i=0;
		int j=s.length-1;
		while(i<j){
			char temp=s[i];
			s[i]=s[j];
			s[j]=temp;
			i++;
			j--;
		}
	}
}
