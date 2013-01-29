package org.cwvs.gfxu.worktime.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.cwvs.gfxu.worktime.domain.Cart;
import org.cwvs.gfxu.worktime.domain.Item;
import org.cwvs.gfxu.worktime.web.struts.BaseAction;
import org.cwvs.gfxu.worktime.web.struts.CartActionForm;


public class AddItemToCartAction extends BaseAction {

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    CartActionForm cartForm = (CartActionForm) form;
    Cart cart = cartForm.getCart();
    String workingItemId = cartForm.getWorkingItemId();
    if (cart.containsItemId(workingItemId)) {
      cart.incrementQuantityByItemId(workingItemId);
    }
		else {
      // isInStock is a "real-time" property that must be updated
      // every time an item is added to the cart, even if other
      // item details are cached.
      boolean isInStock = getPetStore().isItemInStock(workingItemId);
      Item item = getPetStore().getItem(workingItemId);
      cartForm.getCart().addItem(item, isInStock);
    }
    return mapping.findForward("success");
  }

}
