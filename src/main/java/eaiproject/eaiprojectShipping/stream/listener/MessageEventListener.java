/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package eaiproject.eaiprojectShipping.stream.listener;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eaiproject.eaiprojectShipping.stream.sender.MessageEventSender;

import eaiproject.eaiprojectShipping.business.service.ShippingService;
import eaiproject.eaiprojectShipping.data.domain.Shipping;
import eaiproject.eaiprojectShipping.stream.message.EventMessage;
import eaiproject.eaiprojectShipping.stream.message.OrderMessage;


@Component
@EnableBinding(Sink.class)
public class MessageEventListener {

    @Autowired
    private ShippingService shippingService;
    
    @Autowired
    private MessageEventSender messageEventSender;

    private static Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    /**
     * Search for the Call ShipGoods 
     * Create a TrackingId for the customer
     * Send the goods     * 
     * @param eventMessage
     * @throws Exception
     * @author Lukas Weber
     */
    @StreamListener(target = Sink.INPUT,
            condition="(headers['type']?:'')=='ShipGoods'")
    @Transactional
    public void payment(@Payload EventMessage<OrderMessage> eventMessage) throws Exception {
        OrderMessage orderMessage = eventMessage.getPayload();
        logger.info("Payload received: "+ orderMessage.toString());
        Shipping shipping = shippingService.shipGoods(
        		Integer.parseInt(UUID.randomUUID().toString()),  // trackId -> new in this Service
        		Integer.parseInt(orderMessage.getOrderId()),  // orderId -> given from eaieShop
        		Integer.parseInt(orderMessage.getCustomerId()),  // customerId -> given from eaieShop
        		Integer.parseInt(orderMessage.getPackingSlipId()), //packingSlipId -> given from eaiInvetory
        		orderMessage.getParcel_service(), // ParacelService -> given from eaieShop
        		orderMessage.getShipping_address_name(), // ShippingAdress the Name from the customer -> given from eaieShop
        		orderMessage.getShipping_address_street(), // ShippingAdress the Street from the customer -> given from eaieShop
        		orderMessage.getShipping_address_location()); // ShippingAdress the PLZ and destination from the customer -> given from eaieShop
        orderMessage.setTrackingId(shipping.getTrackingId().toString());
        orderMessage.setStatus("GoodsShipped");
        logger.info(orderMessage.toString());
        messageEventSender.send(new EventMessage<>("UpdateLoyalityPoints", orderMessage));
    }


}
