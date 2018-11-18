package eaiproject.eaiprojectShipping.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eaiproject.eaiprojectShipping.data.domain.Shipping;
import eaiproject.eaiprojectShipping.data.repository.ShippingRepository;

public class ShippingService {
	
	@Autowired
	private ShippingRepository shippingRepository;
	
    private Logger logger = LoggerFactory.getLogger(ShippingService.class);

    public Shipping shipGoods(Integer orderId, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) throws Exception {
        logger.info("shipGoods() with orderId " + orderId + " and shipping_adress " + shipping_address_street + " " + shipping_address_location + " called and hand over the parcel to the delivery service " + parcel_service);
        for(long seconds = 5; seconds > 0; seconds--) {
            logger.info("Delivery service ready in " + seconds + " seconds");
            Thread.sleep(1000);
        }
        // ...
        Shipping shipping = new Shipping(orderId, shipping_address_name, shipping_address_street, shipping_address_location, parcel_service);
        logger.info("Packet transferred to delivery service and tracking number "+ shipping.getOrder_id() + " received");
        return shipping;
    }
	
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
