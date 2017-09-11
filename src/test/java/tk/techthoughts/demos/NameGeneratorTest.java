package tk.techthoughts.demos;

import org.junit.Test;

import static org.junit.Assert.*;


public class NameGeneratorTest {

    @Test
    public void testGenerateNames() {
        NameGenerator nameGen = new NameGenerator(3, 7);
        Object[][] name = nameGen.generatefirstAndLastNames(1);

        assertTrue(name.length == 1);
    }

}