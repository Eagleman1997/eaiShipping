/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package eaiproject.eaiprojectShipping.stream.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eaiproject.eaiprojectShipping.business.service.ShippingService;
import eaiproject.eaiprojectShipping.data.domain.Shipping;
import eaiproject.eaiprojectShipping.stream.message.EventMessage;
import eaiproject.eaiprojectShipping.stream.message.OrderMessage;


@Component
@EnableBinding(Sink.class)
public class MessageEventListener {

    @Autowired
    private ShippingService shippingService;

    private static Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @StreamListener(target = Sink.INPUT,
            condition="(headers['type']?:'')=='ShipGoods'")
    @Transactional
    public void payment(@Payload EventMessage<OrderMessage> eventMessage) throws Exception {
        OrderMessage orderMessage = eventMessage.getPayload();
        logger.info("Payload received: "+orderMessage.toString());
        Shipping shipping = shippingService.shipGoods(Long.valueOf(orderMessage.getCustomerId()), orderMessage.getOrderId(), orderMessage.getPackingSlipId());
        orderMessage.setTrackingId(shipping.getTracking_id().toString());
        orderMessage.setStatus("GoodsShipped");
        logger.info(orderMessage.toString());
    }


}
