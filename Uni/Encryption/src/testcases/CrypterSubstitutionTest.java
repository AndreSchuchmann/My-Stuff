package testcases;

import crypter.CrypterFactory;
import crypter.Crypter;
import crypter.IllegalKeyException;
import crypter.IllegalMessageException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ali on 26.05.2015.
 */
public class CrypterSubstitutionTest {
    Crypter cs = new CrypterFactory().getCrypter(CrypterFactory
            .CrypterVerfahren.SUBSTITUTION);
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testVerschluesseln() throws Exception {
        assertTrue(cs.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI",
                "WIKIPEDIAISTINFORMATIV").equals("ZSMSYWPSUSTESNDQVOUESH"));


    }

    @org.junit.Test
    public void testEntschluesseln() throws IllegalMessageException, IllegalKeyException {

        assertEquals("HALLO", cs.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI",
                (cs.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "HALLO"))));

        assertTrue(cs.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI",
                "ZSMSYWPSUSTESNDQVOUESH"
        ).equals("WIKIPEDIAISTINFORMATIV"));

    }
    /*
     * 27 letters
     */
    @Test (expected = IllegalKeyException.class)
    public void testCheckKey() throws Exception {

        cs.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGIG","HALLO");

    }

    /**
     * same letter twice
     * @throws Exception
     */
    @Test (expected = IllegalKeyException.class)
    public void testCheckKey2() throws Exception {
        cs.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGG","HALLO");
        fail();

    }

    //TODO : CHECK FOR ALPHABETIC CHARACTER
    @Test (expected = IllegalKeyException.class)
    public void testCheckKey3() throws Exception {
        cs.verschluesseln(null,"HALLO");
       // fail();

    }



    @org.junit.Test
    public void testIllegalMessage() {
        try {

            cs.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI","Z+33SMSYWPSUSTESNDQVOUESH");
            fail();
        }catch (IllegalKeyException ik){
            assertTrue(false);
        }catch (IllegalMessageException im){

            assertTrue(true);

        }
    }

    @org.junit.Test
    public void testIllegalKey() {
        try {

            cs.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGIa","ZSMSYWPSUSTESNDQVOUESH");
            fail();
        }catch (IllegalKeyException ik){
            assertTrue(true);
        }catch (IllegalMessageException im){
            assertTrue(false);

        }
    }


    @org.junit.Test
    public void testCheckMessage() throws Exception {

    }
}