package productmanagement.model.dto;

public class BankSearchDTO {
	private String name;
	private double minFee;
	private double maxFee;
	
	public BankSearchDTO() {
		this.name = "";
		this.maxFee = -1.0;
		this.minFee = -1.0;
	}
	
	public BankSearchDTO(String name, double minFee, double maxFee) {
		this.name = name;
		this.minFee = minFee;
		this.maxFee = maxFee;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMinFee() {
		return minFee;
	}
	
	public double getMaxFee() {
		return maxFee;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMinFee(double minFee) {
		this.minFee = minFee;
	}
	
	public void setMaxFee(double maxFee) {
		this.maxFee = maxFee;
	}
	
	@Override
	public String toString() {
		return "BankSearchDTO [name=" + name + ", minFee=" + minFee + ", maxFee=" + maxFee + "]";
	}
	
	
}
