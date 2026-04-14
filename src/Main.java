import java.util.Scanner;

import ciphers.CaesarClass;
import ciphers.Cipher;
import ciphers.VigenereClass;

/**
 * 
 */

/**
 * Tester class for the Caesar and Vigenere cipher algorithms implementation
 * @author Miguel
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		testCaesar(input);
		testVigenere(input);
	}

	/**
	 * Test the Caesar cipher algorithm
	 */
	private static void testCaesar(Scanner input) {

		System.out.println("Please enter the message (Latin Alphabet)");
		String message = input.nextLine();
		System.out.println(message);
		System.out.println("Please enter the shift number");
		int shift = input.nextInt() / 26;
		Cipher caesar = new CaesarClass(shift);
		System.out.println("(E)ncode or (D)ecode ?");
		char choice = input.nextLine().charAt(0);
		switch (choice) {
		case 'E':
		case 'e':
			System.out.println("ENCODED MESSAGE IS \n" + caesar.encode(message)); 
			break;
		case 'D':
		case 'd':
			System.out.println("DECODED MESSAGE IS \n" + caesar.decode(message));
		}

	}

	public static void testVigenere(Scanner in) {
		System.out.println("Please enter the message (Latin Alphabet)");
		String message = in.nextLine();
		System.out.println(message);
		System.out.println("Please enter the key (Latin Alphabet, no repetitions)");
		String key = in.nextLine();
		VigenereClass vigenere = new VigenereClass(key);
		System.out.println("(E)ncode or (D)ecode ?");
		char choice = in.nextLine().charAt(0);
		switch (choice) {
		case 'E':
		case 'e':
			System.out.println("ENCODED MESSAGE IS \n" + vigenere.encode(message)); 
			break;
		case 'D':
		case 'd':
			System.out.println("DECODED MESSAGE IS \n" + vigenere.decode(message));
		}

	}
}
