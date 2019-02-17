package encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 17.02.2019
 * Encryptor
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public class Encryptor {

    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    /**
     * Encrypt a string with AES algorithm
     * @param value is a string
     * @return the encrypted string
     */
    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Decrypt a string with AES algorithm
     * @param encrypted is a string
     * @return the decrypted string
     */
    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
