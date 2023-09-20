package _02_data_calculations_actions.referentialTransparency;


import static _02_data_calculations_actions.referentialTransparency.Main.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testThatHypotenuseWorksInNormalCase() {
        assertEquals(5, hypotenuse(3, 4));
        assertEquals(0, hypotenuse(0, 0));
    }
}