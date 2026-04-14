/**
 * 
 */
package ciphers;

/**
 * @author Miguel
 *
 */
public interface Cipher {
	/**
	 * Encrypt a <code>message</code>.
	 * @param message the message to encrypt
	 * @return a mensagem cifrada
	 */
	String encode(String message);
	
	/**
	 * Decrypt an encrypted message
	 * @param message the message to decrypt
	 * @return the decrypted message
	 */
	String decode(String encryptedMessage);
}
