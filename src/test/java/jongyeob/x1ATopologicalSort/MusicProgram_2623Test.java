package jongyeob.x1ATopologicalSort;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicProgram_2623Test {
    private final InputStream originalIn = in;
    private final PrintStream originalOut = out;
    private ByteArrayOutputStream outputCapture;

    @BeforeEach
    void setUp() {
        outputCapture = new ByteArrayOutputStream();
        setOut(new PrintStream(outputCapture));
    }

    @AfterEach
    void tearDown() {
        setIn(originalIn);
        setOut(originalOut);
    }

    private void setInput(String input) {
        setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputCapture.toString().trim();
    }

    @Test
    void 예제1() throws IOException {
        setInput("6 3\n3 1 4 3\n4 6 2 5 4\n2 2 3");
        MusicProgram_2623.main(new String[] {});
        assertEquals("1\n6\n2\n5\n4\n3", getOutput());
    }

}