import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johanrovala on 05/11/15.
 */
public class maintestTest {

    @org.junit.Test
    public void testTest1() throws Exception {
        assertEquals("hej", maintest.test("hej"));
    }

    @org.junit.Test
    public void testtoString() throws Exception{
        String test = "testString";
        assertEquals(test, "testString");
    }
}