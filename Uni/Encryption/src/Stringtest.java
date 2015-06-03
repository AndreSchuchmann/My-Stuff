import crypter.Crypter;
import crypter.CrypterFactory;

/**
 * Created by Ali on 26.05.2015.
 */
public class Stringtest {

    public static void main(String[] args) {


        CrypterFactory amazon = new CrypterFactory();
        Crypter irgendeiner = amazon.getCrypter(CrypterFactory
                .CrypterVerfahren.CAESAR);
        Crypter subs = amazon.getCrypter(CrypterFactory.CrypterVerfahren.SUBSTITUTION);
        try {


            //
            // System.out.println(subs.verschluesseln("A", "VIVI"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("hallo");
        }
    }
}
