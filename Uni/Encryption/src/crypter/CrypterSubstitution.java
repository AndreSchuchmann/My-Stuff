package crypter;

/**
 * Created by André on 21.05.2015.
 */
//TODO: Uppercase!
class CrypterSubstitution implements Crypter {
    private final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Verschl�sselt die message mit dem key durch Substitution
     *
     * @param key     Schl�ssel, der verwendet werden soll.
     * @param message Nachricht, die Verschl�sselt werden soll.
     * @return
     * @throws IllegalKeyException     wenn key nicht 26 buchstaben hat oder
     *                                 nicht jeden Buchstaben nur einmal hat
     * @throws IllegalMessageException Wenn die nachricht nicht ausschlie�lich
     *                                 aus Buchstaben besteht
     */
    @Override
    public String verschluesseln(String key, String message) throws
            IllegalKeyException, IllegalMessageException {
        //TODO: only capital letters?
        //try {
            checkKey(key);
            checkMessage(message);
      //  }catch(Exception e){
      //      System.out.println(e.getMessage());
      //  }
        char[] chiffre = key.toCharArray();
        char[] messageC = message.toCharArray();
        String temp = "";
        for (int i = 0; i < messageC.length; i++) {
            int j = 0;
            while (messageC[i] != ALPHABET[j]) {
                j++;
            }
            temp = temp + chiffre[j];
        }
        return temp;

    }

    /**
     * Entschl�sselt den Key durch Substitution
     *
     * @param key        Schl�ssel, der verwendet werden soll.
     * @param cypherText Nachricht, die entschl�sselt werden soll.
     * @return
     * @throws IllegalKeyException
     * @throws IllegalMessageException
     */
    @Override
    public String entschluesseln(String key, String cypherText) throws
            IllegalKeyException, IllegalMessageException {
        checkKey(key);
        checkMessage(cypherText);
        char[] chiffre = key.toCharArray();
        char[] messageC = cypherText.toCharArray();
        String temp = "";
        for (int i = 0; i < messageC.length; i++) {
            int j = 0;
            while (messageC[i] != chiffre[j]) {
                j++;
            }
            temp = temp + ALPHABET[j];
        }
        return temp;
    }

    /**
     * �berpr�ft ob der key g�ltig ist
     * 1. check ob null
     * 2. check ob nur Gro�buchstaben
     * 3. check auf 26 Zeichen
     * 3. check dass jeder Buchstabe nur einmal vorkommt
     *
     * @param key
     * @throws IllegalKeyException wenn der key nicht 26 Buchstaben hat oder
     * ein Buchstabe 2 mal vorkommt
     */
    public void checkKey(String key) throws IllegalKeyException {
        if(key == null){
            throw new IllegalKeyException("Key darf nicht null sein");
        }
        if (!key.matches("[A-Z]+")) {
            throw new IllegalKeyException("key muss aus Grossbuchstaben " +
                    "bestehen");
        }
        if (key.length() != 26) {
            throw new IllegalKeyException("Key ist zu lang/zu kurz");
        } else {
            for (char c : key.toCharArray()) {
                if (key.indexOf(c) != key.lastIndexOf(c)) {
                    throw new IllegalKeyException("Key darf jeden Buchstaben " +
                            "nur einmal haben");
                }
            }
        }
    }


    /**
     * �berpr�ft ob die Nachricht nur aus Buchstaben besteht
     *
     * @param message
     * @throws IllegalMessageException wenn die Nachricht nicht nur
     *                                 Buchstaben enth�lt
     */
    public void checkMessage(String message) throws IllegalMessageException {
        if(message==null){
            throw new IllegalMessageException("Message darf nicht null sein");
        }
        if (!message.matches("[A-Z]+")) {
            throw new IllegalMessageException("Message muss aus Buchstaben " +
                    "bestehen");
        }
    }


    public static void main(String[] args){
        CrypterSubstitution cs = new CrypterSubstitution();

        try {
            cs.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI","Z+33SMSYWPSUSTESNDQVOUESH");
        } catch (IllegalKeyException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IllegalMessageException e) {
            System.out.println(e.getMessage());


        }
    }
}

