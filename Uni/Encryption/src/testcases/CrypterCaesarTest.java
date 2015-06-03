package testcases;

import crypter.Crypter;
import crypter.CrypterFactory;
import crypter.IllegalKeyException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ali on 02.06.2015.
 */

//TODO: Exceptions testen

public class CrypterCaesarTest {
    CrypterFactory cf = new CrypterFactory();
    Crypter caesar = cf.getCrypter(CrypterFactory
            .CrypterVerfahren.CAESAR);
    @Test (expected = IllegalKeyException.class)
    public void testCheckKey3() throws Exception {
        caesar.verschluesseln("AB", "hallo");

    }

    @Test (expected = IllegalKeyException.class)
    public void testCheckKey2() throws Exception {
        caesar.verschluesseln("a", "hallo");

    }


    @Test
    public void testVerschluesseln() throws Exception {
    assertEquals("IBMMP", caesar.verschluesseln("A", "HALLO"));
        assertEquals("FDHVDU", caesar.verschluesseln("C", "CAESAR"));
    }

    @Test
    public void testEntschluesseln() throws Exception {
        assertEquals("HALLO", caesar.entschluesseln("L",
                (caesar.verschluesseln("L", "HALLO"))));
        assertEquals("HALLO", caesar.entschluesseln("Z", "HALLO"));
    }
}