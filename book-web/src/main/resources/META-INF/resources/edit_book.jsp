<%@ include file="/init.jsp" %>

<%
    Book book = null;

    long bookId = ParamUtil.getLong(request, "bookId");

    if (bookId > 0) {
        book = bookLocalService.getBook(bookId);
    }

    String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:renderURL var="viewBookURL" />

<portlet:actionURL name='<%= book == null ? "addBook" : "editBook" %>' var="addEditBook" windowState="normal" />


<liferay-ui:header
        backURL="<%= viewBookURL %>"
        title='<%= (book != null) ? book.getBookName() : "new-book" %>'
/>

<aui:model-context bean="<%= book %>" model="<%= Book.class %>" />

<aui:form action="<%= addEditBook.toString() %>" method="post" name="fm">
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <aui:input name="bookId" type="hidden" value="<%= bookId %>" />

    <aui:fieldset>

        <aui:input name="bookName" />

        <aui:input name="bookAbstract" />

        <aui:input name="bookAuthorName" />

        <aui:input name="bookOnlinePdf" />

        <aui:input name="bookPageCount" />

        <aui:input name="bookPublishDate" />

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button href="<%= viewBookURL %>" type="cancel" />
    </aui:button-row>

</aui:form>
