package productmanagement.model.entity;

public class Showroom {
	private int id;
	private String name;
	private String address;
	private int cityId;
	public Showroom() {
		super();
	}
	public Showroom(int id, String name, String address, int cityId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cityId = cityId;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getCityId() {
		return cityId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	@Override
	public String toString() {
		return id + "-" + name + "-" + address + "-" + cityId;
	}

	public static Showroom fromStringToShowroom(String str) {
        String[] parts = str.split("-");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String address = parts[2];
        int cityId = Integer.parseInt(parts[3]);
        return new Showroom(id, name, address, cityId);
    }

}
