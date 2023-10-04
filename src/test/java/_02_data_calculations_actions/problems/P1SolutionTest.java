package _02_data_calculations_actions.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1SolutionTest {

    @Test
    void numConsonantsIn() {
        assertEquals(0, P1Solution.numConsonantsIn("aeiou"));
        assertEquals(21, P1Solution.numConsonantsIn("bcdfghjklmnpqrstvwxyz"));
        assertEquals(3, P1Solution.numConsonantsIn("hello"));
        assertEquals(1, P1Solution.numConsonantsIn("is"));
        assertEquals(0, P1Solution.numConsonantsIn("I"));
        assertEquals(0, P1Solution.numConsonantsIn(""));
    }

    @Test
    void pluralize() {
        assertEquals("consonant", P1Solution.pluralize("consonant", 1));
        assertEquals("consonants", P1Solution.pluralize("consonant", 2));
        assertEquals("consonants", P1Solution.pluralize("consonant", 0));
        assertEquals("consonants", P1Solution.pluralize("consonant", -1));
        assertEquals("consonants", P1Solution.pluralize("consonant", 100));

        assertEquals("fly", P1Solution.pluralize("fly", 1));
        assertEquals("flies", P1Solution.pluralize("fly", 2));
    }
}