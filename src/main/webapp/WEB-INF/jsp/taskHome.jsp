<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="fragments/taskHeader.jsp" flush="false"/>

<div id="tabs">
	<h2><fmt:message key="task.list" /></h2>

    <table id="taskTable" class="display">
        <thead>
        <tr>
            <th><fmt:message key="taskId"/></th>
	        <th><fmt:message key="taskName"/></th>
            <th><fmt:message key="taskOwner"/></th>
            <th><fmt:message key="taskBeginDate"/></th>
            <th><fmt:message key="taskCompletedDate"/></th>
            <th><fmt:message key="taskPriority"/></th>
            <th><fmt:message key="taskStatus"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td><c:out value="${task.taskId}"/></td>
                <td><c:out value="${task.taskName}"/></td>
                <td><c:out value="${task.taskOwner}"/></td>
                <td><fmt:formatDate value="${task.taskBeginDate}" type="both"/></td>
                <td><fmt:formatDate value="${task.taskCompletedDate}" type="both"/></td>
                <td><c:out value="${task.taskPriority}"/></td>
                <td><c:out value="${task.taskStatus}"/></td>
                <td><c:url var="editUrl" value="/tasks/${task.taskId}"/>
                    <c:url var="deleteUrl" value="/tasks/${task.taskId}/delete"/>
                    <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
                    <a href="#" class="delete" id="${task.taskId}"><fmt:message key="button.delete"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function () {
    	$(".delete").click(function (event) {
            var a = $(this);
            var id = a.attr("id");
            var url = '<c:url value="tasks/'+id+'/delete"/>';
            $.ajax({
            	type:'GET',
                url:url,                
                success:function (response) {
                    a.parents("tr").remove();
                }
            });
            return false;
        });
    });
   
</script>

</body>
</html>