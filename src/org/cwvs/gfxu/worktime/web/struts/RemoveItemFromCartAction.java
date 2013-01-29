package org.cwvs.gfxu.worktime.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.cwvs.gfxu.worktime.web.struts.BaseAction;
import org.cwvs.gfxu.worktime.web.struts.CartActionForm;

public class RemoveItemFromCartAction extends BaseAction {

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    CartActionForm cartForm = (CartActionForm) form;
    cartForm.getCart().removeItemById(cartForm.getWorkingItemId());
		return mapping.findForward("success");
  }

}
