package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import yjham.hashTable.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("11_해시 테이블 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HashTableTest {

    @Test
    void Design_HashMap() {
        LeetCode_706_DesignHashMap exam = new LeetCode_706_DesignHashMap();

        String[] commands = {"MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"};
        Integer[][] inputs = {null, {1, 1}, {2, 2}, {1}, {3}, {2, 1}, {2}, {2}, {2}};

        Object[] expected = {null, null, null, 1, -1, null, 1, null, -1};
        Object[] actual = exam.useMyHashMap(commands, inputs);

        assertArrayEquals(expected, actual);
    }
}
