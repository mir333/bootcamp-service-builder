<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Book book = (Book) row.getObject();

	long bookId = book.getBookId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/edit_book.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="bookId" value="<%= String.valueOf(bookId) %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="edit" url="<%= editURL %>" />

	<portlet:actionURL name="deleteBook" var="deleteURL">
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="bookId" value="<%= String.valueOf(bookId) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL %>" />

</liferay-ui:icon-menu>
