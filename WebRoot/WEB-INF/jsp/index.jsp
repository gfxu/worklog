<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>gfxu's worklog bench</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="/WEB-INF/jsp/common/meta.jsp" %>
</head>

<body bgcolor="white">

<%@ include file="common/IncludeTop.jsp" %>

<table border="0" cellspacing="0" width="100%">
  <tbody>
  <tr>
    <td valign="top" width="100%">

      <table align="left" border="0" cellspacing="0" width="80%">
        <tbody>
        <tr>
          <td valign="top">

            <!-- SIDEBAR -->

            <table bgcolor="#FFFF88" border="0" cellspacing="0" cellpadding="5" width="200">
              <tbody>
		      <tr>
		      <td>
		        <c:if test="${!empty userSession.account}">
							<b><i><font size="2" color="BLACK">Welcome <c:out value="${userSession.account.firstName}"/>!</font></i></b>
		        </c:if>
		        &nbsp;
		      </td>
		      </tr>
              <tr>
                <td>
                <a href="<c:url value="/shop/viewCategory.do?categoryId=BIRDS"/>">首页</a>
                </td>
              </tr>
              <tr>
                <td>
                <a href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>">周视图</a>
                </td>
              </tr>
              <tr>
                <td>
                <a href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>">月视图</a>
                </td>
              </tr>
              <tr>
                <td>
                <a href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>">计划管理</a>
                </td>
              </tr>
              <tr>
                <td>
                <a href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>">项目管理</a>
                </td>
              </tr>

              </tbody>
             </table>

           </td>
          <td align="center" bgcolor="white" height="300" width="100%">

          <!-- MAIN IMAGE -->

          </td></tr></tbody></table></td></tr>

        </tbody>
        </table>

<%@ include file="common/IncludeBanner.jsp" %>

<%@ include file="common/IncludeBottom.jsp" %>
</body>
</html>
