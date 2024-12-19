package productmanagement;

public class SystemConstant {
	private static final String DEFAULT_PASSWORD = "123456";
	private static final int DEFAULT_STATUS = 1;
	private static final int DEFAULT_ROLEID = 2;
	private static final String HEXKEY = "64616e6776616e68696575456789abcd";
	
	public static int getDefaultRoleid() {
		return DEFAULT_ROLEID;
	}
	
	public static String getHexkey() {
		return HEXKEY;
	}
	
	public static String getDefaultPassword() {
		return DEFAULT_PASSWORD;
	}
	
	public static int getDefaultStatus() {
		return DEFAULT_STATUS;
	}


}
