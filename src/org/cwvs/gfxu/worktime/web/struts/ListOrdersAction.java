package org.cwvs.gfxu.worktime.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.cwvs.gfxu.worktime.web.struts.AccountActionForm;
import org.cwvs.gfxu.worktime.web.struts.SecureBaseAction;

public class ListOrdersAction extends SecureBaseAction {

  protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    AccountActionForm acctForm = (AccountActionForm) form;
    String username = acctForm.getAccount().getUsername();
    request.setAttribute("orderList", getPetStore().getOrdersByUsername(username));
    return mapping.findForward("success");
  }

}
