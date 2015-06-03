package crypter;

/**
 * Created by Ali on 28.05.2015.
 */

class CrypterXOR implements Crypter {
    private final char[] ALPHABET = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_".toCharArray();

    /**
     * verschlüssel einen String mit der XOR verschlüsselung
     * @param key Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     *
     * @return einen Verschlüsselten wert
     * @throws IllegalKeyException Wenn der key ungültig ist
     * @throws IllegalMessageException Wenn die message ungültig ist
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
     * entschlüssel eine Nachricht mit XOR entschlüsselung, ruft die XOR Verschlüsselung auf
     *
     * @param key Schlüssel, der verwendet werden soll.
     * @param cypherText Nachricht, die entschlüsselt werden soll.
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
     * @return einen verlängerten key
     */
    private char[] keyVerlaengern(String key,String message){
        char[] keyTemp = new char[message.length()];

        for(int i = 0; i<keyTemp.length;i++){
            keyTemp[i]=key.charAt(i%key.length());
        }
    return keyTemp;
    }

    /**
     * überprüfe ob der key gültig ist
     * @param key key der zu überprüfen ist
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
