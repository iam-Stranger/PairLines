package by.htp.shape.creator;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdGeneratorTest {
    @Test
    public void generateNextIdTest() throws Exception {
        long value1 = IdGenerator.generateNewId();
        long value2 = IdGenerator.generateNewId();

        assertEquals(value1 + 1, value2);
    }

}