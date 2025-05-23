
package tools;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordProtector {
    public String getProtectedPassword(String password, String salt) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new BigInteger(hash).toString(16);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordProtector.class.getName()).log(Level.SEVERE, "Не найден алгоритм", ex);
        
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(PasswordProtector.class.getName()).log(Level.SEVERE, "Неправильный spec", ex);
        }
        
        return null;
    }
    
    public String getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return new BigInteger(salt).toString(16);
    }

    public String getDecryptedPassword(String code, String salt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}