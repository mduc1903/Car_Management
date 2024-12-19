package productmanagement.model.entity;

public class Bank {
	private int id;
	private String name;
	private double fee;
	
	public Bank() {
		super();
	}

	public Bank(int id, String name, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getFee() {
		return fee;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + fee;
	}
	
	public static Bank fromStringToBank(String str) {
        String[] parts = str.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        double fee = Double.parseDouble(parts[2]);
        return new Bank(id, name, fee);
    }
	
}
