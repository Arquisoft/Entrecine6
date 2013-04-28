package impl.uniovi.asw.entrecine6.central.persistence;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class DataEncryptor {
	Cipher encrypt;
	Cipher decrypt;
	SecretKey key;
	String keyTxt;

	public DataEncryptor(String clave) {
		keyTxt = clave;
		try {
			encrypt = Cipher.getInstance("DES");
			decrypt = Cipher.getInstance("DES");

			KeySpec ks = new DESKeySpec(keyTxt.getBytes("UTF8"));
			
			SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
			SecretKey ky = kf.generateSecret(ks);
			
			encrypt.init(Cipher.ENCRYPT_MODE, ky);
			decrypt.init(Cipher.DECRYPT_MODE, ky);

		} catch (InvalidKeySpecException ex) {
		} catch (UnsupportedEncodingException ex) {
		} catch (InvalidKeyException ex) {
		} catch (NoSuchAlgorithmException ex) {
		} catch (NoSuchPaddingException ex) {
		}
	}

	public String encrypt(String str) {
		try {
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes("UTF8");

			// Encrypt
			byte[] enc = encrypt.doFinal(utf8);

			// Encode bytes to base64 to get a string
			return new Base64Encoder().encode(enc);
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		} 
		return null;
	}

	public String decrypt(String str) {
		try {
			// Decode base64 to get bytes
			byte[] dec = new Base64Encoder().decode(str);

			// Decrypt
			byte[] utf8 = decrypt.doFinal(dec);

			// Decode using utf-8
			return new String(utf8, "UTF8");
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
}