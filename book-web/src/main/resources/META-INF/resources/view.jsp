<%@ include file="/init.jsp" %>

<portlet:renderURL var="redirect" />

<aui:button-row>
	<portlet:renderURL var="addBook">
		<portlet:param name="mvcPath" value="/edit_book.jsp"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
		<portlet:param name="p_p_isolated" value="1"/>
	</portlet:renderURL>
	<aui:button value="add-book" onClick="<%= addBook.toString() %>" />
</aui:button-row>


<liferay-ui:search-container
		emptyResultsMessage="empty-results-message"
		total="<%= bookLocalService.getBooksCount() %>"

>

	<liferay-ui:search-container-results
			results="<%= bookLocalService.getBooks(searchContainer.getStart(), searchContainer.getEnd()) %>" />

	<liferay-ui:search-container-row
			className="com.liferay.bootcamp.model.Book"
			keyProperty="bookId"
			modelVar="book"
			escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text name="id" property="bookId"/>

		<liferay-ui:search-container-column-text name="book-name" property="bookName" />
		<liferay-ui:search-container-column-text name="book-abstract" property="bookAbstract"  />
		<liferay-ui:search-container-column-text name="book-author-name" property="bookAuthorName" />
		<liferay-ui:search-container-column-text name="book-online-pdf" property="bookOnlinePdf"  />
		<liferay-ui:search-container-column-text name="book-page-count" property="bookPageCount" />
		<liferay-ui:search-container-column-date name="book-publish-date" value="<%= book.getBookPublishDate() %>" />

		<liferay-ui:search-container-column-jsp path="/book_action.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
