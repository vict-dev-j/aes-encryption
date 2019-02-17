package encryption;

import static encryption.Encryptor.decrypt;
import static encryption.Encryptor.encrypt;

/**
 * 17.02.2019
 * Main
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public class Main {

    public static void main(String[] args) {
        String originalString = "Hello, World";
        System.out.println("String to encrypt data - " + originalString);
        String encryptedString = encrypt(originalString);
        System.out.println("Encrypted String - " + encryptedString);
        String decryptedString = decrypt(encryptedString);
        System.out.println("After decryption - " + decryptedString);
    }
}
