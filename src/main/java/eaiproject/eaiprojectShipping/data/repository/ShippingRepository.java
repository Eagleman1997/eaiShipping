package eaiproject.eaiprojectShipping.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import eaiproject.eaiprojectShipping.data.domain.Shipping;


public interface ShippingRepository extends JpaRepository<Shipping, Integer>{

	public List<Shipping> findShippingsByTrackingId(@Param("tracking_id") Integer TrackingId);
	public List<Shipping> findShippingsByOrderId(@Param("order_id") Integer OrderId);
	
}
