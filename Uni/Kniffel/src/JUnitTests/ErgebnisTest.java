package JUnitTests;

import static org.junit.Assert.*;
import logic.Wuerfel;
import logic.Wurf;

import org.junit.Test;

import ergebnisse.Ergebnis;


public class ErgebnisTest {

    @Test
    public void testErgebnis() {
        fail("Not yet implemented");
    }

    @Test
    public void testUeberpruefen() {
       Wurf w1 = new Wurf();
        
    }

    @Test
    public void testPunkteBerechnen() {
        fail("Not yet implemented");
    }

    @Test
    public void testPunkteAnrechnen() {
        fail("Not yet implemented");
    }

    @Test
    public void testGleicheZahlen() {
        Wurf test1 = new Wurf();

        System.out.println(test1);
        assertEquals(3, Ergebnis.gleicheZahlen(test1));
    }

    @Test
    public void testAufsteigendeZahlen() {
        Wurf test1 = new Wurf();

        System.out.println(test1);
        assertEquals(3, Ergebnis.aufsteigendeZahlen(test1));
    }

}
