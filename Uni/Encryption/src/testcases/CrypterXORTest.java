package testcases;

import crypter.Crypter;
import crypter.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ali on 02.06.2015.
 */
public class CrypterXORTest {
    Crypter cx = new CrypterFactory().getCrypter(CrypterFactory
            .CrypterVerfahren.XOR);
    @Test
    public void testVerschluesseln() throws Exception {
        assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",
        cx.verschluesseln("TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

    }

    @Test
    public void testEntschluesseln() throws Exception {

        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", cx.entschluesseln
                ("TPERULES", "URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
    }
}