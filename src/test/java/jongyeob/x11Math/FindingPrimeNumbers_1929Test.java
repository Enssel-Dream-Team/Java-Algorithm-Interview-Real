package jongyeob.x11Math;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindingPrimeNumbers_1929Test {
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
        setInput("3 16\n");
        FindingPrimeNumbers_1929.main(new String[]{});
        assertEquals("3\n5\n7\n11\n13", getOutput());
    }

}