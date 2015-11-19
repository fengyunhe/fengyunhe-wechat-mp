import org.dom4j.DocumentException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AESTest
{
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();
        ObjectOutputStream oop = new ObjectOutputStream(new
                FileOutputStream("C:\\Users\\lvsk\\key.dat"));
        oop.writeObject(key);
        oop.close();

        String strTest = "Hello, Jason";
        byte[] strAfterAES = encryptData(strTest.getBytes());
        System.out.println(new String(strAfterAES));
        byte[] strOriContent = decryptData(strAfterAES);
        System.out.println(new String(strOriContent));
    }


    public static byte[] encryptData(byte[] input) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\lvsk\\key.dat"));
        SecretKey aeskey = (SecretKey) in.readObject();
        Cipher c1 = Cipher.getInstance("AES");
        c1.init(Cipher.ENCRYPT_MODE, aeskey);
        byte[] cipherByte = c1.doFinal(input);
        return cipherByte;
    }


    public static byte[] decryptData(byte[] input) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\lvsk\\key.dat"));
        SecretKey aeskey = (SecretKey) in.readObject();
        Cipher c1 = Cipher.getInstance("AES");
        c1.init(Cipher.DECRYPT_MODE, aeskey);
        byte[] clearByte = c1.doFinal(input);
        return clearByte;
    }
}
