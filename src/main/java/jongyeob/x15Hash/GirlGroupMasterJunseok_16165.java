package jongyeob.x15Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class GirlGroupMasterJunseok_16165 {
    public static void main(String[] args) throws IOException {
        HashMap<String, List<String>> groupInformation = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            String teamName = reader.readLine();
            int numOfPeople = Integer.parseInt(reader.readLine());
            List<String> peoples = new ArrayList<>();
            for (int j = 0; j < numOfPeople; j++) {
                peoples.add(reader.readLine());
            }
            Collections.sort(peoples);
            groupInformation.put(teamName, peoples);
        }
        for (int i = 0; i < m; i++) {
            String find = reader.readLine();
            int flag = Integer.parseInt(reader.readLine());
            if (flag == 0) {
                List<String> members = groupInformation.get(find);
                for (String member : members) {
                    System.out.println(member);
                }
            } else {
                for (Map.Entry<String, List<String>> stringEntry : groupInformation.entrySet()) {
                    if (stringEntry.getValue().contains(find)) {
                        System.out.println(stringEntry.getKey());
                        break;
                    }
                }
            }
        }
    }
}
