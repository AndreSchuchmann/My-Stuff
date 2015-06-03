package crypter;

/**
 * Created by André on 28.05.2015.
 */
class CrypterCaesar implements Crypter {
    private final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();


    @Override
    public String verschluesseln(String key, String message) throws
            IllegalKeyException, IllegalMessageException {
        checkKey(key);
        checkMessage(message);
        int step = (int) (key.charAt(0) - 'A' + 1);
        char[] messageC = message.toCharArray();
        char[] chiffre = new char[ALPHABET.length];

        for (int i = 0; i < ALPHABET.length; i++) {
            chiffre[i] = ALPHABET[(i + step + 26) % 26];
        }
        for (int i = 0; i < messageC.length; i++) {
            int j = 0;
            while (messageC[i] != ALPHABET[j]) {
                j++;
            }
            messageC[i] = chiffre[j];
        }

        return new String(messageC);
    }



    @Override
    public String entschluesseln(String key, String cypherText) throws
            IllegalKeyException, IllegalMessageException {
    /**    int step = 'Z'-(key.charAt(0)-'A'+1);
        String stepC = (char) step +"";
        return verschluesseln(stepC,cypherText);**/

        checkKey(key);
        checkMessage(cypherText);
        int step = (int) (key.charAt(0) - 'A' + 1);
        char[] messageC = cypherText.toCharArray();
        char[] chiffre = new char[ALPHABET.length];

        for (int i = 0; i < ALPHABET.length; i++) {
            chiffre[i] = ALPHABET[(i - step + 26) % 26];
        }
        for (int i = 0; i < messageC.length; i++) {
            int j = 0;
            while (messageC[i] != ALPHABET[j]) {
                j++;
            }
            messageC[i] = chiffre[j];
        }

        return new String(messageC).toUpperCase();


    }

    public void checkKey(String key) throws IllegalKeyException {
        if (key == null) {
            throw new IllegalKeyException("Key darf nicht null sein");
        }
        //checck, ob es aus nur einem buchstaben besteht
        if (!key.matches("[A-Z]")) {
            throw new IllegalKeyException("Key darf nur Gro�buchstaben " +
                    "enthalten");

        }
    }

    private void checkMessage(String message) throws IllegalMessageException {
        if (message == null) {
            throw new IllegalMessageException("Message darf nich null sein");
        }
        if (!message.matches("[A-Z]+")) {
            throw new IllegalMessageException("Message darf nur " +
                    "Gro�buchstaben enthalten");
        }


    }





    public static void main(String[] arg) {
        CrypterCaesar cs = new CrypterCaesar();
        try {
            System.out.println(cs.verschluesseln("B", "ABCDEFG"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
