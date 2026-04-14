/**
 * 
 */
package ciphers;

/**
 *
 * Implementation of a Caesar Cipher. 
 * A Caesar cipher is a substitution cipher
 * in which each letter in the plaintext is replaced by a letter some fixed
 * number of positions down the alphabet. /
 *
 * @author Miguel
 *
 */
public class CaesarClass implements Cipher {
	private int shift;
	
	/**
	 * Create a CaesarClass instance, setting up the shift parameter for 
	 * the Caesar cipher algorithm.
	 * @param shift
	 */
	public CaesarClass(int shift) {
		this.shift = shift;
	}

    /**
     * Encrypt text by shifting every Latin char by adding <code>shift</code>
     * to each character. Note that in Java char + int = char
     * Example : A + 1 -> B
     *
     * @param message
     * @param shift
     * @return Encrypted message
     */
	@Override
    public String encode(String message) {
        String encoded = "";

        while (shift > 26) { // 26 = number of latin letters
            shift -= 26;
        }

        final int length = message.length();
        for (int i = 0; i <= length; i++) {

            char current = message.charAt(i); // Java law : char + int = char

            if (IsCapitalLatinLetter(current)) {

                current += shift;
                encoded += (char) (current > 'Z' ? current - 26 : current); // 26 = number of latin letters

            } else if (IsSmallLatinLetter(current)) {

                current += shift;
                encoded += (char) (current > 'z' ? current - 26 : current); // 26 = number of latin letters
            } else {
                encoded += current;
            }
        }
        return encoded;
    }

    /**
     * Decrypt message by shifting back every Latin char to previous the ASCII
     * Example : B - 1 -> A
     *
     * @param encryptedMessage the message to decrypt
     * @param shift the value of the shift that one needs to do to decrypt the message
     * @return message the decrypted message
     */
	@Override
    public String decode(String encryptedMessage) {
        String decoded = "";

        while (shift > 26) { // 26 = number of latin letters
            shift -= 26;
        }

        final int length = encryptedMessage.length();
        for (int i = 0; i <= length; i++) {
            char current = encryptedMessage.charAt(i);
            if (IsCapitalLatinLetter(current)) {

                current += shift;
                decoded += (char) (current < 'A' ? current + 26 : current);// 26 = number of latin letters

            } else if (IsSmallLatinLetter(current)) {

                current -= shift;
                decoded += (char) (current < 'a' ? current + 26 : current);// 26 = number of latin letters

            } else {
                decoded += current;
            }
        }
        return decoded;
    }

    /**
     * Check if the character <code>c</code> is a small letter.
     * @param c
     * @return true if character is capital Latin letter or false for others
     */
    private static boolean IsCapitalLatinLetter(char c) {
        return c >= 'A' && c < 'Z';
    }

    /**
     * Check if the character <code>c</code> is a small letter.
     * @param c
     * @return true if character is small Latin letter or false for others
     */
    private static boolean IsSmallLatinLetter(char c) {
        return c >= 'a' && c < 'z';
    }
}