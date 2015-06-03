package crypter;

/**
 * Created by André on 28.05.2015.
 */

class CrypterXOR implements Crypter {
    private final char[] ALPHABET = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_".toCharArray();

    /**
     * verschl�ssel einen String mit der XOR verschl�sselung
     * @param key Schl�ssel, der verwendet werden soll.
     * @param message Nachricht, die Verschl�sselt werden soll.
     *
     * @return einen Verschl�sselten wert
     * @throws IllegalKeyException Wenn der key ung�ltig ist
     * @throws IllegalMessageException Wenn die message ung�ltig ist
     */
    @Override
    public String verschluesseln(String key, String message) throws IllegalKeyException, IllegalMessageException {
        char[] keyLang = new char[26];
        keyLang = keyVerlaengern(key,message);
        char[] messageChar = new char[message.length()];
        messageChar = message.toCharArray();
        char[] verschluesselt = new char[message.length()];
        for(int i=0;i<verschluesselt.length;i++){
            int temp = zahlWert(messageChar[i])^zahlWert(keyLang[i]);
            verschluesselt[i]= ALPHABET[temp];
        }

        return new String(verschluesselt);
    }

    /**
     * entschl�ssel eine Nachricht mit XOR entschl�sselung, ruft die XOR Verschl�sselung auf
     *
     * @param key Schl�ssel, der verwendet werden soll.
     * @param cypherText Nachricht, die entschl�sselt werden soll.
     *
     * @return
     * @throws IllegalKeyException
     * @throws IllegalMessageException
     */
    @Override
    public String entschluesseln(String key, String cypherText) throws IllegalKeyException, IllegalMessageException {
        return verschluesseln(key,cypherText);
    }

    /**
     * gebe jedem Zeichen einen Zahlenwert um durch das XOR den neuen Wert zu kriegen
     * @ = 0 , A = 1, ...
     * @param a das Zeichen zu dem ein wert kommen soll
     * @return den Wert der Zahl
     */
    private int zahlWert(char a){
        int i=0;
       while(ALPHABET[i]!=a){
           i++;
       }
        return i;
    }

    /**
     * mache den key so lange wie die message
     * @param key
     * @return einen verl�ngerten key
     */
    private char[] keyVerlaengern(String key,String message){
        char[] keyTemp = new char[message.length()];

        for(int i = 0; i<keyTemp.length;i++){
            keyTemp[i]=key.charAt(i%key.length());
        }
    return keyTemp;
    }

    /**
     * �berpr�fe ob der key g�ltig ist
     * @param key key der zu �berpr�fen ist
     * @throws IllegalKeyException wenn der key null ist
     * oder wenn der key nicht buchstaben von A bis Z oder @, \ [,],_ , ^ beinhaltet
     */
    private void checkKey(String key) throws IllegalKeyException {
    if (key == null){
        throw new IllegalKeyException();
    }if(!key.matches("[@-_]+")){
            throw new IllegalKeyException();
        }
    }

}
