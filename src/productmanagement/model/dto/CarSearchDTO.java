package productmanagement.model.dto;

public class CarSearchDTO {
	private String name;
	private Double minPrice;
	private Double maxPrice;
	private Integer minSeats;
	private Integer maxSeats;
	private String typeCar;
	private String color;

	public CarSearchDTO() {
		this.name = "";
		this.minPrice = -1.0;
		this.maxPrice = -1.0;
		this.minSeats = -1;
		this.maxSeats = -1;
		this.typeCar = "";
		this.color = "";
	}

	public CarSearchDTO(String name, double minPrice, double maxPrice, int minSeats, int maxSeats, String manufacturer,
			String color) {
		this.name = name;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minSeats = minSeats;
		this.maxSeats = maxSeats;
		this.typeCar = manufacturer;
		this.color = color;
	}


	public String getName() {
		return name;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public Integer getMinSeats() {
		return minSeats;
	}

	public Integer getMaxSeats() {
		return maxSeats;
	}

	public String getTypeCar() {
		return typeCar;
	}

	public String getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setMinSeats(Integer minSeats) {
		this.minSeats = minSeats;
	}

	public void setMaxSeats(Integer maxSeats) {
		this.maxSeats = maxSeats;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CarSearchDTO [name=" + name + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", minSeats="
				+ minSeats + ", maxSeats=" + maxSeats + ", manufacturer=" + typeCar + ", color=" + color + "]";
	}
}
