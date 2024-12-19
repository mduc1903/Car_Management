package productmanagement.model.entity;

public class Role {
	private int id;
	private String name;
	private String role;
	public Role(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public Role() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return id + "," + name + "," + role;
	}

}
