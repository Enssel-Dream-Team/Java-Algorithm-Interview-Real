package jongyeob.x03Array;

import java.io.IOException;
import java.util.Scanner;

public class RoomAssignment_13300 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int numOfStudent = sc.nextInt();
        int maxRoomCapacity = sc.nextInt();
        int[][] gradeInfo = getGradeInfo(numOfStudent);
        int result = solve(gradeInfo, maxRoomCapacity);
        System.out.println(result);
    }

    public static int solve(int[][] gradeInfo, int maxRoomCapacity) {
        int numOfRoomNeeds = 0;
        for(int i = 0 ; i < 6; i++){
            int girlRoom = (int)Math.ceil((double)gradeInfo[i][0] / maxRoomCapacity);
            int boyRoom = (int)Math.ceil((double)gradeInfo[i][1] / maxRoomCapacity);
            numOfRoomNeeds += (girlRoom + boyRoom);
        }
        return numOfRoomNeeds;
    }

    public static int[][] getGradeInfo(int repeat) {
        int[][] gradeInfo = new int[6][2];
        for(int i = 0 ; i < repeat; i++){
            int gender = sc.nextInt();
            int grade = sc.nextInt() -1;
            gradeInfo[grade][gender]++;
        }
        return gradeInfo;
    }
}
