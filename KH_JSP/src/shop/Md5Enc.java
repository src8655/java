package shop;

import java.security.MessageDigest;

public class Md5Enc {
	public static String getEncMD5(byte[] buffer) {
		StringBuffer sbuf = new StringBuffer();
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(buffer);
			byte[] msgStr = mDigest.digest();
			for (int i = 0; i < msgStr.length; i++) {
				String tmpEncTxt = Integer.toHexString((int) msgStr[i] & 0x00ff);
				sbuf.append(tmpEncTxt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sbuf.toString().toUpperCase();
	}
}

