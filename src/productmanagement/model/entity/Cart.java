package productmanagement.model.entity;

public class Cart extends Car{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cart_quantity;
	private double cart_price;

	public Cart() {
		super();
		this.cart_price = -1.0;
		cart_quantity = 0;
	}

	public Cart(int id, String name, int numberOfSeats, double price, String typeCar, String size, double momen,
			int wattage, String description, int numberOfAirBag, int total, String version, String color,
			int cart_quantity, double cart_price) {
		super(id, name, numberOfSeats, price, typeCar, size, momen, wattage, description, numberOfAirBag, total,
				version, color);
		this.cart_quantity = cart_quantity;
		this.cart_price = cart_price;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public double getCart_price() {
		return cart_price;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public void setCart_price(double cart_price) {
		this.cart_price = cart_price;
	}
	
	public double totalPrice() {
		return cart_price * cart_quantity;
	}

	@Override
	public String toString() {
		return super.toString() + "," + cart_quantity + "," + cart_price;
	}
}
