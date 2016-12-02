package cn.com.businessservicesplatform.common.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
 
public class DESUtils {
	
	private static final String ALGORITHM = "DES";
	
	private static final String DEFAULT_KEY = "4221e3e62865466c8fb3a88b46011302";

	/**
	 * <p>
	 * 生成随机密钥
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey() throws Exception {
		return getSecretKey(null);
	}

	/**
	 * <p>
	 * 生成密钥
	 * </p>
	 * 
	 * @param seed
	 *            密钥种子
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey(String seed) throws Exception {
		SecretKey secretKey = generateKey(seed);
		return encode(secretKey.getEncoded());
	}

	/** 
	 * 获得密钥,解决Linux 环境下报错问题 
	 * @param  String secretKey 加密解密的种子 
	 * @throws NoSuchAlgorithmException  
	 * @throws InvalidKeyException  
	 * @throws InvalidKeySpecException 
	 * @return SecretKey
	 */  
	private static SecretKey generateKey(String secretKey) throws NoSuchAlgorithmException,InvalidKeyException,InvalidKeySpecException{  
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);  
	    DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());  
	    keyFactory.generateSecret(keySpec);  
	    return keyFactory.generateSecret(keySpec);  
	}  
	
	/**
	 * <p>
	 * 加密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception {
		Key k = toKey(decode(DEFAULT_KEY));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
	}
	
	/**
	 * <p>
	 * 加密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		Key k = toKey(decode(key));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
	}

	/**
	 * <p>
	 * 解密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data) throws Exception {
		Key k = toKey(decode(DEFAULT_KEY));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return  new String(cipher.doFinal(Base64.decodeBase64(data.getBytes("UTF-8"))),"UTF-8");
	}
	
	/**
	 * <p>
	 * 解密
	 * </p>
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws Exception {
		Key k = toKey(decode(key));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return  new String(cipher.doFinal(Base64.decodeBase64(data.getBytes("UTF-8"))),"UTF-8");
	}

	/**
     * <p>
     * BASE64字符串解码为二进制数据
     * </p>
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] decode(String base64) throws Exception {
        return Base64.decodeBase64(base64.getBytes());
    }
    
    /**
     * <p>
     * 二进制数据编码为BASE64字符串
     * </p>
     * 
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(byte[] bytes) throws Exception {
        return new String(Base64.encodeBase64(bytes));
    }
	 
    /**
	 * <p>
	 * 转换密钥
	 * </p>
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}
	
	
	public  static String getUuid(){
		 UUID uuid = UUID.randomUUID();
	     System.out.println(uuid);
	     return uuid.toString().replaceAll("-", "");
	}
	   
	
	 public static void main(String[] args) {
		 try {
			String msg = "12|timer|18";
			 String sign =  DESUtils.encrypt(msg);
			 System.err.println(sign);
//			 String outputStr = new String(byt,"UTF-8");
//			 System.out.println(outputStr);
			 String data = DESUtils.decrypt(sign);
			 System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
//		 System.err.println(getUuid());
//		 try {
//			System.err.println(DESUtils.getSecretKey("QDFDMkMyRTQ="));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
//		 String cookieValue = "XtIO2iZiCR4/T2AheHugyBB0O+yKgQ1hFjiwzIwTCMIua/MuZrP99OXoe1aauxMdBC2lSqYMqyo=";
//		 String key = "QDFDMkMyRTQ=";
//		 
//		try {
//			byte[] outputData;
//			outputData = DESUtils.decrypt(decode(cookieValue),key);
//			 String outputStr = new String(outputData);
//			 System.out.println(outputStr);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
