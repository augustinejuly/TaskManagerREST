<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
  
    <spring:url value="/resources/css/style.css" var="styleCss" />
	<link href="${styleCss}" rel="stylesheet" />
	
	<spring:url value="/resources/css/form.css" var="formCss" />
	<link href="${formCss}" rel="stylesheet" />
    
    <spring:url value="/resources/js/jquery-1.11.2.min.js" var="jQueryJS" />
	<script src="${jQueryJS}"></script>
	
	<spring:url value="/resources/js/jquery-ui.js" var="jQueryUI" />
	<script src="${jQueryUI}"></script>

</head>

<h2><fmt:message key="webapp.name" /></h2>

<div id="navcontainer">
    <ul id="navlist">
        <li><a href="<%= request.getContextPath() %>/tasks"><fmt:message key="menu.tasks.list"/></a></li>
        <li><a href="<%= request.getContextPath() %>/tasks/new"><fmt:message key="menu.tasks.create"/></a></li>
    </ul>
</div>
