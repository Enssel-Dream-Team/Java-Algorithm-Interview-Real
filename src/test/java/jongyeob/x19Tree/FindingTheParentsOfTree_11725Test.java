package jongyeob.x19Tree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindingTheParentsOfTree_11725Test {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputCapture;

    @BeforeEach
    void setUp() {
        outputCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapture));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputCapture.toString().trim();
    }

    @Test
    void 예제1() throws IOException {
        setInput("7\n1 6\n6 3\n3 5\n4 1\n2 4\n4 7");
        FindingTheParentsOfTree_11725.main(new String[] {});
        assertEquals("4\n6\n1\n3\n1\n4", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("12\n1 2\n1 3\n2 4\n3 5\n3 6\n4 7\n4 8\n5 9\n5 10\n6 11\n6 12");
        FindingTheParentsOfTree_11725.main(new String[] {});
        assertEquals("1\n1\n2\n3\n3\n4\n4\n5\n5\n6\n6", getOutput());
    }
}