package eaiproject.eaiprojectShipping.data.domain;

import javax.persistence.*;

@Entity
public class Shampoo {
	
	@Id
	private Integer shampooId;
	private String name;
	private String brand;
	private String type;
	private Double price;
	
	public Shampoo() {
		super();
	}

	/**
	 * Create a new Shampoo if its needed
	 * @param shampooId
	 * @param name
	 * @param brand
	 * @param type
	 * @param price
	 * @author Lukas Weber
	 */
	public Shampoo(Integer shampooId, String name, String brand, String type, Double price) {
		this.shampooId = shampooId;
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.price = price;
	}
	
	public Integer getShampoo_id() {
		return shampooId;
	}

	public void setShampoo_id(Integer shampooId) {
		this.shampooId = shampooId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
