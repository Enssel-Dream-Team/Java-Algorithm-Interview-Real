package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P01063 {

	static Map<String, Direction> directionMap;

	public static void main(String[] args) throws IOException {
		init();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Point king = Converter.stringToPoint(st.nextToken());
		Point rock = Converter.stringToPoint(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			move(king, rock, br.readLine());
		}

		System.out.println(Converter.pointToString(king));
		System.out.println(Converter.pointToString(rock));
	}

	static void move(Point king, Point rock, String stringDir) {
		Direction dir = directionMap.get(stringDir);
		if (checkRock(king, rock, dir)) {
			if (rock.canMove(dir)) {
				rock.move(dir);
				king.move(dir);
			}
		} else {
			if (king.canMove(dir)) {
				king.move(dir);
			}
		}
	}

	static boolean checkRock(Point king, Point rock, Direction dir) {
		return (king.x + dir.x == rock.x) && (king.y + dir.y == rock.y);
	}

	static void init() {
		directionMap = new HashMap<>();
		directionMap.put("R", new Direction(1, 0));
		directionMap.put("L", new Direction(-1, 0));
		directionMap.put("B", new Direction(0, 1));
		directionMap.put("T", new Direction(0, -1));
		directionMap.put("RT", new Direction(1, -1));
		directionMap.put("LT", new Direction(-1, -1));
		directionMap.put("RB", new Direction(1, 1));
		directionMap.put("LB", new Direction(-1, 1));
	}

	static class Converter {

		static String pointToString(Point p) {
			char col = (char) ('A' + p.x);
			int row = 8 - p.y;
			return col + "" + row;
		}

		static Point stringToPoint(String s) {
			int x = s.charAt(0) - 'A';
			int y = 8 - Integer.parseInt(s.substring(1));
			return new Point(x, y);
		}

	}

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void move(Direction dir) {
			x += dir.x;
			y += dir.y;
		}

		public boolean canMove(Direction dir) {
			int fx =  x + dir.x;
			int fy = y + dir.y;
			return 0 <= fx && fx < 8 && 0 <= fy && fy < 8;
		}

	}

	static class Direction {
		int x, y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
