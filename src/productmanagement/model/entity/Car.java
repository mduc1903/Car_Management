package productmanagement.model.entity;

import java.io.Serializable;

public class Car implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int numberOfSeats;
	private double price;
	private String typeCar;
	private String size;
	private double momen;
	private int wattage;
	private String description;
	private int numberOfAirBag;
	private int total;
	private String version;
	private String color;

	public Car() {

	}

	public Car(int id, String name, int numberOfSeats, double price, String typeCar, String size, double momen,
			int wattage, String description, int numberOfAirBag, int total, String version, String color) {
		this.id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
		this.typeCar = typeCar;
		this.size = size;
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

	public double getPrice() {
		return price;
	}

	public int getTotal() {
		return total;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getTypeCar() {
		return typeCar;
	}

	public String getSize() {
		return size;
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

	public String getVersion() {
		return version;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public void setSize(String size) {
		this.size = size;
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

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + numberOfSeats + "," + price + "," + typeCar + "," + size + "," + momen + "," + wattage + "," + description + "," + numberOfAirBag + "," + total + "," + version + "," + color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static Car fromStringToCar(String str) {
        String[] parts = str.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int numberOfSeats = Integer.parseInt(parts[2]);
        double price = Double.parseDouble(parts[3]);
        String typeCar = parts[4];
        String size = parts[5];
        double momen = Double.parseDouble(parts[6]);
        int wattage = Integer.parseInt(parts[7]);
        String description = parts[8];
        int numberOfAirBag = Integer.parseInt(parts[9]);
        int total = Integer.parseInt(parts[10]);
        String version = parts[11];
        String color = parts[12];
        return new Car(id, name, numberOfSeats, price, typeCar, size, momen, wattage, description, numberOfAirBag, total, version, color);
    }

}
