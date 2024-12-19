package productmanagement.utils;

public class StringUtils {
	public static boolean checkString(String str) {
		if(str != null && !str.isEmpty()) {
			return true;
		}
		return false;
	}
}
