/**
 * 
 */
package utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @author JoshuaBoudreau
 *
 */
public class PasswordService {

	/**
	 * Create a hashed version of password
	 */
	public String encrypt(String password) {
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}
}
