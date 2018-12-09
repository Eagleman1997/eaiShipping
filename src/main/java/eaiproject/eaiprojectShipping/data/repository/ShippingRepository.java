package eaiproject.eaiprojectShipping.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import eaiproject.eaiprojectShipping.data.domain.Shipping;

/**
 * Find Shipping by the TrackingId or by the orderId
 * @author Lukas Weber
 */
public interface ShippingRepository extends JpaRepository<Shipping, Integer>{

	public List<Shipping> findShippingsByTrackingId(@Param("trackingId") Integer TrackingId);
	public List<Shipping> findShippingsByOrderId(@Param("orderId") Integer OrderId);
	
}
