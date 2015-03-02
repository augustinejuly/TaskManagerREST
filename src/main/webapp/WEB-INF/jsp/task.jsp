<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="fragments/taskHeader.jsp" flush="false"/>

<div id="content">
    <h2><fmt:message key="update.form.title"/></h2>

	<form:form modelAttribute="task" method="post" cssClass="basic-grey">
	    <form:hidden path="taskId" />
	  
	    <fieldset>
	        <div class="form-row">
	            <label for="taskName"><fmt:message key="taskName"/>:</label>
	            <form:input path="taskName" />
                <form:errors path="taskName" />
            </div>
	        <div class="form-row">
	            <label for="taskOwner"><fmt:message key="taskOwner"/>:</label>
	            <form:input path="taskOwner" />
                <form:errors path="taskOwner" />
	        </div>
	        <div class="form-row">
	            <label for="taskPriority"><fmt:message key="taskPriority"/>:</label>
	            <form:select path="taskPriority">
							<form:option value="">Select Task Priority</form:option>
							<form:options />
				</form:select>
                <form:errors path="taskPriority" />
            </div>
	        <div class="form-row">
	            <label for="taskStatus"><fmt:message key="taskStatus"/>:</label>
				  <form:select path="taskStatus">
							<form:option value="">Select Task Status</form:option>
							<form:options />
				</form:select>	            
                <form:errors path="taskStatus" />
	        </div>
	        <div class="form-buttons">
	            <div class="button"><input id="btnSave" type="submit" value="<fmt:message key="button.save"/>" /></div>
	        </div>
	    </fieldset>
	</form:form>
</div>


</body>
</html>