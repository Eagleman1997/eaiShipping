package eaiproject.eaiprojectShipping.data.domain;

import javax.persistence.*;

@Entity
public class Shipping {
	
	@Id @GeneratedValue
	private Integer trackingId;
	private Integer orderId;
	private Integer customerId;
	private Integer packingSlipId;
	private String shipping_address_name;
	private String shipping_address_street;
	private String shipping_address_location;
	private String parcel_service;

	public Shipping(){
		super();
	}
	
	public Shipping(Integer trackingId, Integer orderId, Integer customerId, Integer packingSlipId, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		this.trackingId = trackingId;
		this.orderId = orderId;
		this.customerId = customerId;
		this.packingSlipId = packingSlipId;
		this.parcel_service = parcel_service;
		this.shipping_address_name = shipping_address_name;
		this.shipping_address_street = shipping_address_street;
		this.shipping_address_location = shipping_address_location;
    }

	public Integer getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
