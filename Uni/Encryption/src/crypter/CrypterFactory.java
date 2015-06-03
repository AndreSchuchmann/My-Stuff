package crypter;

/**
 * Created by André on 02.06.2015.
 */

public class CrypterFactory {
    public enum CrypterVerfahren {
        CAESAR, SUBSTITUTION, XOR
    }

    public CrypterFactory() {
    }


    public Crypter getCrypter(CrypterVerfahren c) {
        switch (c) {
            case CAESAR:
                return new CrypterCaesar();
            case SUBSTITUTION:
                return new CrypterSubstitution();
            case XOR:
                return new CrypterXOR();
            default:
                break;
        }


    return null;
    }

}
