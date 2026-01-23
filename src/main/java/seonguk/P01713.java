package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class P01713 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Candidate> candidates = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Candidate c = new Candidate(Integer.parseInt(st.nextToken()), i);
			if (candidates.contains(c)) {
				Candidate candidate = candidates.get(candidates.indexOf(c));
				candidate.getScore();
			} else {
				if (candidates.size() == N) {
					Collections.sort(candidates);
					candidates.remove(candidates.size() - 1);
				}
				candidates.add(c);
			}
		}

		List<Integer> result = new ArrayList<>();
		candidates.forEach(c -> result.add(c.student));

		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		result.forEach(num -> sb.append(num).append(" "));

		System.out.println(sb);
		br.close();
	}

	static class Candidate implements Comparable<Candidate> {
		int student;
		int score;
		int old;

		public Candidate(int student, int old) {
			this.student = student;
			this.score = 1;
			this.old = old;
		}

		public void getScore() {
			score++;
		}

		@Override
		public int compareTo(Candidate o) {
			if (this.score == o.score) {
				return o.old - this.old;
			}
			return o.score - this.score;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass())
				return false;
			Candidate candidate = (Candidate)o;
			return student == candidate.student;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(student);
		}
	}

}
