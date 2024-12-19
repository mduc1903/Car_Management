package productmanagement.model.entity;

public class User {
	private int id;
	private String fullName;
	private String gmail;
	private String phoneNumber;
	private String password;
	private int status;
	private int roleId;

	public User() {

	}

	public User(int id, String fullName, String gmail, String phoneNumber, String password, int status, int roleId) {
		this.id = id;
		this.fullName = fullName;
		this.gmail = gmail;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.status = status;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGmail() {
		return gmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return id + "," + fullName + "," + gmail + "," + phoneNumber + "," + password + "," + status + "," + roleId;
	}

	public static User fromStringToUser(String str) {
        String[] parts = str.split(",");
        int id = Integer.parseInt(parts[0]);
        String fullName = parts[1];
        String gmail = parts[2];
        String phoneNumber = parts[3];
        String password = parts[4];
        int status = Integer.parseInt(parts[5]);
        int roleId = Integer.parseInt(parts[6]);
        return new User(id, fullName, gmail, phoneNumber, password, status, roleId);
    }


}
