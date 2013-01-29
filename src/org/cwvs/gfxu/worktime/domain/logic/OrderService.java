package org.cwvs.gfxu.worktime.domain.logic;

import org.cwvs.gfxu.worktime.domain.Order;
import org.cwvs.gfxu.worktime.domain.logic.PetStoreFacade;
import org.cwvs.gfxu.worktime.domain.logic.PetStoreImpl;

/**
 * Separate OrderService interface, implemented by PetStoreImpl
 * in addition to PetStoreFacade.
 *
 * <p>Mainly targeted at usage as remote service interface,
 * just exposing the <code>getOrder</code> method.
 *
 * @author Juergen Hoeller
 * @since 26.12.2003
 * @see PetStoreFacade
 * @see PetStoreImpl
 * @see org.cwvs.gfxu.worktime.service.JaxRpcOrderService
 */
public interface OrderService {

	Order getOrder(int orderId);

}
