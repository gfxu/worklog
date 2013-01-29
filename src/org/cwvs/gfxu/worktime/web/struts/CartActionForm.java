package org.cwvs.gfxu.worktime.web.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.cwvs.gfxu.worktime.domain.Cart;
import org.cwvs.gfxu.worktime.web.struts.BaseActionForm;


public class CartActionForm extends BaseActionForm {

  /* Private Fields */

  private Cart cart = new Cart();
  private String workingItemId;

  /* JavaBeans Properties */

  public Cart getCart() { return cart; }
  public void setCart(Cart cart) { this.cart = cart; }

  public String getWorkingItemId() { return workingItemId; }
  public void setWorkingItemId(String workingItemId) { this.workingItemId = workingItemId; }

  /* Public Methods */

  public void reset(ActionMapping mapping, HttpServletRequest request) {
    super.reset(mapping, request);
    workingItemId = null;
  }
}
