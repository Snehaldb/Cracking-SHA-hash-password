package CS265_1;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Sha1Analyzer {

    public String sha1Encrypt(String permutedString){
        try {
            String encryptedString = null;
            MessageDigest message = MessageDigest.getInstance("SHA-1");
            message.update(permutedString.getBytes("UTF-8"), 0, permutedString.length());
            encryptedString = DatatypeConverter.printHexBinary(message.digest());
            return encryptedString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}