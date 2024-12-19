package productmanagement.utils;

public class NumberUtils {
	public static boolean isDouble(String str) {
	    try {
	        Double.parseDouble(str);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}

	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}

	public static boolean positiveNumber(Double number) {
		if(number >= 0) {
			return true;
		}
		return false;
	}

	public static boolean positiveNumber(Integer number) {
		if(number >= 0) {
			return true;
		}
		return false;
	}
}
