package productmanagement.model.entity;

public class Booking {
	private int id;
	private String typeCar;
	private int cityId;
	private int showroomId;
	private String note;
	private int userId;
	public Booking() {
		super();
	}
	public Booking(int id, String typeCar, int cityId, int showroomId, String note, int userId) {
		super();
		this.id = id;
		this.typeCar = typeCar;
		this.cityId = cityId;
		this.showroomId = showroomId;
		this.note = note;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public String getTypeCar() {
		return typeCar;
	}
	public int getCityId() {
		return cityId;
	}
	public int getShowroomId() {
		return showroomId;
	}
	public String getNote() {
		return note;
	}
	public int getUserId() {
		return userId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return id + "," + typeCar + "," + cityId + "," + showroomId + "," + note + "," + userId;
	}
	public static Booking fromStringToBooking(String str) {
        String[] parts = str.split(",");
        int id = Integer.parseInt(parts[0]);
        String typeCar = parts[1];
        int cityId = Integer.parseInt(parts[2]);
        int showroomId = Integer.parseInt(parts[3]);
        String note = parts[4];
        int userId = Integer.parseInt(parts[5]);
        return new Booking(id, typeCar, cityId, showroomId, note, userId);
    }

}
