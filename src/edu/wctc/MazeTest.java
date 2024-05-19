package edu.wctc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    //JUnit to test and make sure that the Front door is the ONLY room that is exitable.
    @Test
    void testExitableRoom() {
        Room exitableRoom = new FrontDoor("Main Entrance");
        assertTrue(exitableRoom instanceof Exitable, "Front Door Should Be Exitable");

        Room nonExitableRoom = new Roof("RoofTop");
        assertFalse(nonExitableRoom instanceof Exitable, "Rooftop Should not be Exitable");

        Room nonExitableRoom2 = new Basement("Basement");
        assertFalse(nonExitableRoom2 instanceof Exitable, "Basement Should not be Exitable");

    }
}