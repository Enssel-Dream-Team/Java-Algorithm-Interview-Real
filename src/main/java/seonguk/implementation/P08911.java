package seonguk.implementation;

import java.io.*;

public class P08911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            Turtle turtle = new Turtle();
            br.readLine().chars().forEach(c -> {
                moveTurtle(turtle, (char) c);
            });
            bw.write(turtle.calcArea() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void moveTurtle(Turtle turtle, char c) {
        switch (c) {
            case 'F':
                turtle.moveF();
                break;
            case 'B':
                turtle.moveB();
                break;
            case 'R':
                turtle.turnR();
                break;
            default:
                turtle.turnL();
        }
    }

    static class Turtle {

        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};

        int x, y;
        int dir;
        int minX, maxX, minY, maxY;

        public Turtle() {
            x = 0;
            y = 0;
            dir = 0;
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;
        }

        public void moveF() {
            x += dx[dir];
            y += dy[dir];
            setPosition();
        }

        public void moveB() {
            x -= dx[dir];
            y -= dy[dir];
            setPosition();
        }

        public void turnR() {
            dir = (dir + 1) % 4;
        }

        public void turnL() {
            dir = (dir + 3) % 4;
        }

        public int calcArea() {
            return (maxX - minX) * (maxY - minY);
        }

        private void setPosition() {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
    }
}
