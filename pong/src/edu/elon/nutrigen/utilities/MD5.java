package edu.elon.nutrigen.utilities;


/**
 * Grabbed of internet and matches the one used in actionscript by nutrigen.
 * 
 * @author dpowell2
 *
 */
public class MD5 {
	
	public static void main(String [] args) {
		String s = "femme";
		String result = MD5convert(s);
		System.out.println(result);
		//9c291829783371ff068ce793c6daf235	
		String email = "youngwoman";
		result = MD5convert(email);
		System.out.println(result);
		
	}

	public static String MD5convert(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			//intentionally empty
		}
		return null;
	}

}
