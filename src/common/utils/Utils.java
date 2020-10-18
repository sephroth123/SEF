package common.utils;

public class Utils {

	public static boolean beginWith(String tempString, String firstLetter) {

		String s = tempString.substring(0, 1);

		if (s.equals(firstLetter)) {
			return true;

		}

		return false;

	}

	public static boolean isNull(String s) {

		if ("".equals(s)) {

			return true;

		}
		if (null == s) {
			return true;
		}

		return false;

	}

}
