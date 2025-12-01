package jongyeob.x0DSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SharkElementarySchool_21608 {
    private static Student[] students;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        students = new Student[N * N];
        map = new int[N][N];
        for (int i = 0; i < N * N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int number = Integer.parseInt(tokenizer.nextToken());
            int[] near = new int[4];
            for (int j = 0; j < 4; j++) {
                near[j] = Integer.parseInt(tokenizer.nextToken());
            }
            students[i] = new Student(number, near);
        }
        simulation(N);
        long score = calculateScore(N);
        System.out.println(score);
    }

    private static long calculateScore(int N) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Student current = findStudent(map[i][j]);
                int likeCnt = 0;
                int[][] nextPos = new int[][] {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
                for (int[] next : nextPos) {
                    if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N) {
                        for (int nearStudent : current.nearStudents) {
                            if (map[next[0]][next[1]] == nearStudent) {
                                likeCnt++;
                                break;
                            }
                        }
                    }
                }
                result += getCountScore(likeCnt);
            }
        }
        return result;
    }

    private static long getCountScore(int likeCnt) {
        if (likeCnt == 0)
            return 0;
        else if (likeCnt == 1)
            return 1;
        else if (likeCnt == 2)
            return 10;
        else if (likeCnt == 3)
            return 100;
        else
            return 1000;
    }

    private static Student findStudent(int number) {
        for (Student student : students) {
            if (student.number == number)
                return student;
        }
        return new Student(0, new int[] {0, 0, 0, 0});
    }

    private static void simulation(int N) {
        for (int i = 0; i < N * N; i++) {
            int[] nearStudents = students[i].nearStudents;
            int[] best = scanNear(N, nearStudents);
            map[best[0]][best[1]] = students[i].number;
        }
    }

    private static int[] scanNear(int N, int[] nearStudents) {
        // y, x, likeCnt, emptyCnt
        int[] bestPos = new int[] {-1, -1, -1, -1};
        // 완전 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 빈칸이 아닐 경우
                if (map[i][j] != 0)
                    continue;
                int[][] nextPos = new int[][] {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
                int emptyCnt = 0;
                int likeCnt = 0;
                for (int[] next : nextPos) {
                    if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N) {
                        if (map[next[0]][next[1]] == 0) {
                            emptyCnt++;
                        } else {
                            for (int nearStudent : nearStudents) {
                                if (map[next[0]][next[1]] == nearStudent) {
                                    likeCnt++;
                                    break;
                                }
                            }
                        }
                    }
                }
                // 좋아하는 학생의 수가 best와 같을 때
                if (bestPos[2] == likeCnt) {
                    // 주변 빈칸 수가 best보다 적을 때
                    if (bestPos[3] < emptyCnt) {
                        bestPos = new int[] {i, j, likeCnt, emptyCnt};
                        // 주변 빈칸 수가 best와 같을 때
                    } else if (bestPos[3] == emptyCnt) {
                        // 좌상단에 가까울 경우만 업데이트
                        if (bestPos[0] > i || (bestPos[0] == i && bestPos[1] > j))
                            bestPos = new int[] {i, j, likeCnt, emptyCnt};
                    }
                    // 좋아하는 학생의 수가 best 보다 많을 때
                } else if (bestPos[2] < likeCnt) {
                    bestPos = new int[] {i, j, likeCnt, emptyCnt};
                }
            }
        }
        return bestPos;
    }

    private static class Student {
        int number;
        int[] nearStudents;

        public Student(int number, int[] nearStudents) {
            this.number = number;
            this.nearStudents = nearStudents;
        }
    }
}
