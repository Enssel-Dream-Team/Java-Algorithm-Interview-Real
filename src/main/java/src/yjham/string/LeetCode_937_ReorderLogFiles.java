package src.yjham.string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_937_ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		List<String> letter = new ArrayList<>();
		List<String> digit = new ArrayList<>();

		for (String log : logs) {
			if (Character.isDigit(log.split(" ")[1].charAt(0))) {
				digit.add(log);
			} else {
				letter.add(log);
			}
		}

		letter.sort((a, b) -> {
			String[] aSplit = a.split(" ", 2);
			String[] bSplit = b.split(" ", 2);

			return aSplit[1].equals(bSplit[1]) ? aSplit[0].compareTo(bSplit[0]) : aSplit[1].compareTo(bSplit[1]);
		});

		letter.addAll(digit);

		return letter.toArray(new String[0]);
	}
}
