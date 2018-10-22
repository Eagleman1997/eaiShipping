package eaiproject.eaiprojectShipping.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import eaiproject.eaiprojectShipping.data.domain.Shipping;
import eaiproject.eaiprojectShipping.data.repository.ShippingRepository;

public class ShippingService {
	
	@Autowired
	private ShippingRepository shippingRepository;
	
	public Shipping createShipping(Integer orderId, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		Shipping shipping = new Shipping(orderId, shipping_address_name, shipping_address_street, shipping_address_location, parcel_service);
		return shippingRepository.save(shipping);
	}
	
	public Shipping readShippingById(String orderId) {
		return shippingRepository.findById(Integer.parseInt(orderId)).orElse(null);
	}
	
	public Shipping updateShipping(String orderId, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		Shipping shipping = new Shipping(Integer.parseInt(orderId), shipping_address_name, shipping_address_street, shipping_address_location, parcel_service);
		shipping.setOrder_id(Integer.parseInt(orderId));
		return shippingRepository.save(shipping);
	}

}
