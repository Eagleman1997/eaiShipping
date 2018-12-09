package eaiproject.eaiprojectShipping.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eaiproject.eaiprojectShipping.data.domain.Shipping;
import eaiproject.eaiprojectShipping.data.repository.ShippingRepository;

@Service
public class ShippingService {
	
	@Autowired
	private ShippingRepository shippingRepository;
	
    private Logger logger = LoggerFactory.getLogger(ShippingService.class);

    /**
     * Send / ship all the goods
     * @param trackingId
     * @param orderId
     * @param customerId
     * @param packingSlipId
     * @param parcelService
     * @param shipping_address_name
     * @param shipping_address_street
     * @param shipping_address_location
     * @return shipping
     * @throws Exception
     * @author Lukas Weber
     */
    public Shipping shipGoods(Integer trackingId, Integer orderId, Integer customerId , Integer packingSlipId, String parcelService, String shipping_address_name, String shipping_address_street, String shipping_address_location) throws Exception {
        logger.info("shipGoods() with orderId " + orderId + " and customer_id " + customerId + " and packingSlip_id " + packingSlipId + " called and hand over the parcel to the delivery service " + parcelService + "to adress " + shipping_address_name + " " + shipping_address_street + " " + shipping_address_location);
        for(long seconds = 5; seconds > 0; seconds--) {
            logger.info("Delivery service ready in " + seconds + " seconds");
            Thread.sleep(1000);
        }
        // ...
        Shipping shipping = new Shipping(trackingId, orderId, customerId, packingSlipId, parcelService, shipping_address_name, shipping_address_street, shipping_address_location);
        logger.info("Packet transferred to delivery service and tracking number "+ shipping.getOrderId() + " received");
        return shipping;
    }
	
    /**
     * Shipping
     * Methods for create, read and update shipping
     * @author Lukas Weber
     */
	public Shipping createShipping(Integer tracking_id, Integer orderId, Integer customer_id, Integer packingSlip_id, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		Shipping shipping = new Shipping(tracking_id, orderId, customer_id, packingSlip_id, shipping_address_name, shipping_address_street, shipping_address_location, parcel_service);
		return shippingRepository.save(shipping);
	}
	
	public Shipping readShippingById(String orderId) {
		return shippingRepository.findById(Integer.parseInt(orderId)).orElse(null);
	}
	
	public Shipping updateShipping(Integer tracking_id, Integer orderId, Integer customer_id, Integer packingSlip_id, String shipping_address_name, String shipping_address_street, String shipping_address_location, String parcel_service) {
		Shipping shipping = new Shipping(tracking_id, orderId, customer_id, packingSlip_id, shipping_address_name, shipping_address_street, shipping_address_location, parcel_service);
		shipping.setOrderId(orderId);
		return shippingRepository.save(shipping);
	}

}
