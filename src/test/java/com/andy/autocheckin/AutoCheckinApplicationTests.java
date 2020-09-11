package com.andy.autocheckin;

import org.apache.tomcat.util.buf.HexUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class AutoCheckinApplicationTests {

	@Test
	void contextLoads() {


		String inputResult = "707590281.011536040953875A123456789e109eef9d4a045e4a0d6f498eaffbe13cf4a4030TWCADefault";
		String assertResult = "27e10695681e35dcec84870ab34a70d0ce35d02471682bf3600b995ae3d40b60";
		try {
			final MessageDigest instance = MessageDigest.getInstance("SHA-256");
			final byte[] digest = instance.digest(inputResult.getBytes("UTF-16LE"));
			String hexString = HexUtils.toHexString(digest).toLowerCase();
			hexString = byte2Hex(digest).toLowerCase();
			System.out.println("result: " + hexString);
			Assert.assertEquals(assertResult,hexString );
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}


	}


	/**
	 * 將byte轉為16進位制
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes){
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i=0;i<bytes.length;i++){
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length()==1){
				//1得到一位的進行補0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}

}
