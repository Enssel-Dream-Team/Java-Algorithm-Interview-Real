package string;

import java.util.*;

class LeetCode_937_ReorderDataInLogFiles {
	static class Log implements Comparable<Log>{
		int idx;
		int isDigitLog;
		String identifier;
		String content;

		public Log (int idx, int isDigitLog, String identifier, String content) {
			this.idx = idx;
			this.isDigitLog = isDigitLog;
			this.identifier = identifier;
			this.content = content.substring(identifier.length() + 1);
		}

		public int compareTo(Log anotherLog){
			if (this.isDigitLog != anotherLog.isDigitLog){
				return Integer.compare(this.isDigitLog, anotherLog.isDigitLog);
			}
			if (this.isDigitLog == 1){
				return Integer.compare(this.idx, anotherLog.idx);
			}
			if (this.content.equals(anotherLog.content))
				return this.identifier.compareTo(anotherLog.identifier);

			return this.content.compareTo(anotherLog.content);
		}

		public String toString(){
			return "(" + idx + ", " + identifier + ", " + content + ")";
		}
	}
	public String[] reorderLogFiles(String[] logs) {
		StringTokenizer st;
		Log[] logArray = new Log[logs.length];

		for (int i=0;i<logs.length;i++){
			String log = logs[i];
			st = new StringTokenizer(log);
			String first = st.nextToken();
			char second = st.nextToken().charAt(0);

			Log instance = new Log(i, second - '0' >= 0 && second - '0' <= 9 ? 1 : 0, first, log);
			logArray[i] = instance;
		}

		Arrays.sort(logArray);

		String[] answer = new String[logs.length];
		for (int i=0;i<logs.length;i++){
			answer[i] = logArray[i].identifier + " " + logArray[i].content;
		}
		return answer;
	}
}