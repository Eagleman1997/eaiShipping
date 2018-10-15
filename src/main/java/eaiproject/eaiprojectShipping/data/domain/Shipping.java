package eaiproject.eaiprojectShipping.data.domain;

import javax.persistence.*;

@Entity
public class Shipping {
	
	@Id @GeneratedValue
	private Integer tracking_id;
	private Integer order_id;
	private String shipping_address_name;
	private String shipping_address_street;
	private String shipping_address_location;
	private String parcel_service;

	public Shipping(){
		super();
	}

}
