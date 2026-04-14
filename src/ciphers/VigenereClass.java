/**
 * 
 */
package ciphers;

/**
 * @author Miguel
 *
 */
public class VigenereClass implements Cipher {
	public String key;
	private String result;

	// Creates a new instance of the Vigenere cipher encoder/decoder
	// key - the encoding/deconding key
	public VigenereClass(String key) {
		this.key = key;
		this.result = "";
	}

	/**
	 * Encode the <code>message</code> using the Vigenere algorithm.
	 * @param message the message to encode
	 */
	public String encode(final String message) {
		result = "";

		for (int i = 0, j = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					result += (char) ((c + key.toUpperCase().charAt(j) - 2 * 'A') % 26 + 'A');

				} else {
					result += (char) ((c + key.toLowerCase().charAt(j) - 2 * 'a') % 26 + 'a');

				}
			} else {
				result += c;
			}
			j = j++ % key.length();
		}
		return result;
	}

	/**
	 * Decode the <code>message</code> using the Vigenere algorithm.
	 * @param message the message to decode
	 * @return the decoded message
	 */
	public String decode(final String message) {
		result = "";

		for (int i = 0, j = 0; i < message.length(); i++) {

			char c = message.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					result += ((char) ('Z' - (25 - (c - key.toUpperCase().charAt(j))) % 26));

				} else {
					result += ((char) ('Z' - (25 - (c - key.toLowerCase().charAt(j))) % 26));

				}
			} else {
				result += c;
			}

			j = j++ % key.length();

		}
		return result;
	}
}