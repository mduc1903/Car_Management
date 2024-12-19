package productmanagement.model.dto;

public class CarAddDTO {
	private int id;
	private String name;
	private int numberOfSeats;
	private double price;
	private String typeCar;
	private double length;
	private double width;
	private double height;
	private double momen;
	private int wattage;
	private String description;
	private int numberOfAirBag;
	private int total;
	private String version;
	private String color;

	public CarAddDTO() {

	}

	public CarAddDTO(int id, String name, int numberOfSeats, double price, String typeCar, double length, double width,
			double height, double momen, int wattage, String description, int numberOfAirBag, int total, String version,
			String color) {
		this.id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
		this.typeCar = typeCar;
		this.length = length;
		this.width = width;
		this.height = height;
		this.momen = momen;
		this.wattage = wattage;
		this.description = description;
		this.numberOfAirBag = numberOfAirBag;
		this.total = total;
		this.version = version;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public double getPrice() {
		return price;
	}

	public String getTypeCar() {
		return typeCar;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getMomen() {
		return momen;
	}

	public int getWattage() {
		return wattage;
	}

	public String getDescription() {
		return description;
	}

	public int getNumberOfAirBag() {
		return numberOfAirBag;
	}

	public int getTotal() {
		return total;
	}

	public String getVersion() {
		return version;
	}

	public String getColor() {
		return color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setMomen(double momen) {
		this.momen = momen;
	}

	public void setWattage(int wattage) {
		this.wattage = wattage;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNumberOfAirBag(int numberOfAirBag) {
		this.numberOfAirBag = numberOfAirBag;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setColor(String color) {
		this.color = color;
	}


}
