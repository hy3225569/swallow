

    
package com.sea.swallow.common;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;



/**
* @ClassName: AES
* @Description: AES解密工具
* @author hy
* @date 2016年6月30日
*
*/

public class AES {
	//私钥AES
	private static final String privatekey = "L+\\~f4,Ir)b$=pkf";

    /**
     * @Method: desEncrypt
     * @Description: 解密工具
     * @param @param ciphertext 密文（最后6位是混淆码，不需要base64解码）
     * @param @param publickey(endtime规则: 以 100 纳秒为单位表示的当前的日期和时间长整型值的字符串)
     * @param @return
     * @param @throws Exception    参数
     * @return String    返回类型
     * @throws
     * @author hy
     * @date 2016年6月30日
     **/
        
    public static String desEncrypt(String ciphertext,String publickey) throws Exception {
        try
        {
        	int length=ciphertext.length();
    		//获取混淆码
    		String confusioncode=StringUtils.substring(ciphertext, length-6, length);
    		//截取预解密的 密文
    		String cryptText=StringUtils.substring(ciphertext, 0, length-6);
    		//生成公钥，并MD5加密
    		String key=publickey+confusioncode+publickey;
    		key=MD5II(Base64.encodeBase64String(key.getBytes()));
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(privatekey.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            
          //BASE64解码后，解密文
            byte[] original = cipher.doFinal(Base64.decodeBase64(cryptText));
            return new String(original).trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @Method: encrypt
     * @Description: 加密算法
     * @param @param plaintext 明文
     * @param @param publickey 公钥
     * @param @param confusioncode 混淆码（6位随机数）
     * @param @return
     * @param @throws Exception    参数
     * @return String    返回类型
     * @throws
     * @author hy
     * @date 2016年6月30日
     **/
        
    public static String encrypt(String plaintext,String publickey,String confusioncode) throws Exception {
        try {

        	//生成公钥，并MD5加密
            String key = publickey+confusioncode+publickey;
            key=MD5II(Base64.encodeBase64String(key.getBytes()));

            //加密链
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = plaintext.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintextBytes = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintextBytes, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(privatekey.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            
            //加密
            byte[] encrypted = cipher.doFinal(plaintextBytes);

            
           //BASE64 编码
            return Base64.encodeBase64String(encrypted)+confusioncode;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
	 * @Method: MD5
	 * @Description: md5加密工具(明文)
	 * @param @param plain
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @author hy
	 * @date 2016年6月30日 
	 **/
	    
//	private static String MD5(String plain) {
//		String re_md5 = new String();
//		MessageDigest md;
//		try {
//			md = MessageDigest.getInstance("md5");
//			md.update(plain.getBytes());
//			byte b[] = md.digest();
//			int i;
//			StringBuffer buf = new StringBuffer("");
//			for (int offset = 0; offset < b.length; offset++) {
//				i = b[offset];
//				if (i < 0)
//					i += 256;
//				if (i < 16)
//					buf.append("0");
//				buf.append(Integer.toHexString(i));
//			}
//
//			re_md5 = buf.toString();
//			
//			System.out.println(re_md5);
//			
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return re_md5;
//	}
	
    /**
	 * @Method: MD5II
	 * @Description: md5加密工具(明文)
	 * @param @param plain
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @author hy
	 * @date 2016年6月30日
	 **/
	
	private static String MD5II(String plain) {
		return Hashing.md5().newHasher().putString(plain, Charsets.UTF_8).hash().toString();
	}
    
//    private static String getRandom(){
//    	return RandomStringUtils.randomAlphanumeric(6);
//    } 
    
//    public static void main(String[] args) throws Exception {
//    	
//    	String mSign = "c66b1588-f6ab-49d4-b917-6376956b4247";
//    	
//    	String sign="gJaRJc2JEZZ7Ma3avKsfwg==abcdef";
//    	String sendtime="635916883470454300";
//    	
//    	System.out.println(RandomStringUtils.randomAlphanumeric(6));
//
////    	System.out.println(Base64.encodeToString(key.getBytes(), Base64.NO_WRAP));
//    	
//    	
//    	System.out.println(encrypt("11223344", "635916883470454300","J2yRu8"));
//    	
//    	
//    	System.out.println(desEncrypt("VfV21A0fK82PwZ3mrqDMWg==abcdef", sendtime));
//    	
//    }
	public static String bytesToHex(byte[] data) {
		if (data == null) {
			return null;
		}

		int len = data.length;
		String str = "";
		for (int i = 0; i < len; i++) {
			if ((data[i] & 0xFF) < 16)
				str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
			else
				str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
		}
		return str;
	}
//
//	public static byte[] hexToBytes(String str) {
//		if (str == null) {
//			return null;
//		} else if (str.length() < 2) {
//			return null;
//		} else {
//			int len = str.length() / 2;
//			byte[] buffer = new byte[len];
//			for (int i = 0; i < len; i++) {
//				buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
//			}
//			return buffer;
//		}
//	}

}
