package src.jongyeob;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import jongyeob.x04LinkedList.Editor_1406;

public class LinkedListTest {
    static Stream<Arguments> editorCase() {
        return Stream.of(
            Arguments.of(String.join("\n",
                "abcd",
                "3",
                "P x",
                "L",
                "P y"
            ), "abcdyx"),
            Arguments.of(String.join("\n",
                "abc",
                "9",
                "L",
                "L",
                "L",
                "L",
                "L",
                "P x",
                "L",
                "B",
                "P y"
            ), "yxabc"),
            Arguments.of(String.join("\n",
                "dmih",
                "11",
                "B",
                "B",
                "P x",
                "L",
                "B",
                "B",
                "B",
                "P y",
                "D",
                "D",
                "P z"
            ), "yxz")
        );
    }

    @ParameterizedTest
    @MethodSource("editorCase")
    void 에디터_1406(String input, String expected) {
        String out = TestIO.runWithInput(() -> {
            try {
                Editor_1406.main(new String[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, input);
        assertEquals(expected, out);
    }
}
