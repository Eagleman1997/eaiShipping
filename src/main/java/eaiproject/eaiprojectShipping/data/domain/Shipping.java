package eaiproject.eaiprojectShipping.data.domain;

import javax.persistence.*;

@Entity
public class Shipping {
	
	@Id @GeneratedValue
	private Integer tracking_id;
	private Integer order_id;
	private Integer customer_id;
	private Integer packingSlip_id;
	private String shipping_address_name;
	private String shipping_address_street;
	private String shipping_address_location;
	private String parcel_service;

	public Shipping(){
		super();
	}
	
	public Shipping(Integer tracking_id, Integer order_id, Integer customer_id, Integer packingSlip_id, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		this.tracking_id = tracking_id;
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.packingSlip_id = packingSlip_id;
		this.parcel_service = parcel_service;
		this.shipping_address_name = shipping_address_name;
		this.shipping_address_street = shipping_address_street;
		this.shipping_address_location = shipping_address_location;
    }

	public Integer getTracking_id() {
		return tracking_id;
	}

	public void setTracking_id(Integer tracking_id) {
		this.tracking_id = tracking_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getShipping_address_name() {
		return shipping_address_name;
	}

	public void setShipping_address_name(String shipping_address_name) {
		this.shipping_address_name = shipping_address_name;
	}

	public String getShipping_address_street() {
		return shipping_address_street;
	}

	public void setShipping_address_street(String shipping_address_street) {
		this.shipping_address_street = shipping_address_street;
	}

	public String getShipping_address_location() {
		return shipping_address_location;
	}

	public void setShipping_address_location(String shipping_address_location) {
		this.shipping_address_location = shipping_address_location;
	}

	public String getParcel_service() {
		return parcel_service;
	}

	public void setParcel_service(String parcel_service) {
		this.parcel_service = parcel_service;
	}

}
