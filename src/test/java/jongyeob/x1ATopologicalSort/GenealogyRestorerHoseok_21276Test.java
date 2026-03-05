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

class GenealogyRestorerHoseok_21276Test {
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
        setInput(
            "7\ndaeil sangdo yuri hoseok minji doha haeun\n7\nhoseok sangdo\nyuri minji\nhoseok daeil\ndaeil sangdo\nhaeun doha\ndoha minji\nhaeun minji");
        GenealogyRestorerHoseok_21276.main(new String[] {});
        assertEquals(
            "2\nminji sangdo \ndaeil 1 hoseok \ndoha 1 haeun \nhaeun 0 \nhoseok 0 \nminji 2 doha yuri \nsangdo 1 daeil \nyuri 0",
            getOutput());
    }
}