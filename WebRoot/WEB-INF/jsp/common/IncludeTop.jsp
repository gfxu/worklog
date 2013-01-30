<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>

<table background="images/bkg-topbar.gif" border="0" cellspacing="0" cellpadding="5" width="100%">
  <tbody valign="middle">
  <tr>
    <td width="80%"><a href="<c:url value="/shop/index.do"/>"><img border="0" src="images/logo-topbar.gif" /></a></td>
    <td align="right">

	<c:if test="${empty userSession.account}" >
	      <a href="<c:url value="/shop/signonForm.do"/>"><img border="0" name="img_signin" src="images/sign-in.gif" /></a>
	</c:if>
	
	<c:if test="${!empty userSession.account}" >
	      <a href="<c:url value="/shop/signoff.do"/>"><img border="0" name="img_signout" src="images/sign-out.gif" /></a>
	      <img border="0" src="images/separator.gif" />
	      <a href="<c:url value="/shop/editAccount.do"/>"><img border="0" name="img_myaccount" src="images/my_account.gif" /></a>
	</c:if>

      <img border="0" src="images/separator.gif" /><a href="../help.html"><img border="0" name="img_help" src="images/help.gif" /></a>
    </td>
    <td align="left">
      <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
			  <input type="hidden" name="search" value="true"/>
        <input name="keyword" size="14" />&nbsp;<input border="0" src="images/search.gif" type="image"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>