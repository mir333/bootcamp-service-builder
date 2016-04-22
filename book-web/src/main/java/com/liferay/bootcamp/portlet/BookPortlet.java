package com.liferay.bootcamp.portlet;

import com.liferay.bootcamp.model.Book;
import com.liferay.bootcamp.service.BookLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Book Portlet",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.resource-bundle=content.Language"
        },
        service = Portlet.class
)
public class BookPortlet extends MVCPortlet {


    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute("bookLocalService", _bookLocalService);

        super.doDispatch(renderRequest, renderResponse);
    }

    public void addBook(ActionRequest request, ActionResponse response)
            throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        Book book = _bookLocalService.createBook(0);

        Date now = new Date();
        book.setCompanyId(themeDisplay.getCompanyId());
        book.setGroupId(themeDisplay.getScopeGroupId());
        book.setUserId(themeDisplay.getUserId());
        book.setCreateDate(now);
        book.setModifiedDate(now);
        book.setUserId(themeDisplay.getUserId());
        book.setBookName(ParamUtil.getString(request, "bookName"));
        book.setBookAuthorName(ParamUtil.getString(request, "bookAuthorName"));
        book.setBookAbstract(ParamUtil.getString(request, "bookAbstract"));
        book.setBookOnlinePdf(ParamUtil.getBoolean(request, "bookOnlinePdf"));
        book.setBookPageCount(ParamUtil.getInteger(request, "bookPageCount"));
        book.setBookPublishDate(getDate(request, "bookPublishDate"));

        _bookLocalService.addBook(book);

        sendRedirect(request, response);

    }

    public void editBook(ActionRequest request, ActionResponse response)
            throws Exception {

        long bookId = ParamUtil.getLong(request, "bookId");
        Book book = _bookLocalService.fetchBook(bookId);

        book.setModifiedDate(new Date());
        book.setBookName(ParamUtil.getString(request, "bookName"));
        book.setBookAuthorName(ParamUtil.getString(request, "bookAuthorName"));
        book.setBookAbstract(ParamUtil.getString(request, "bookAbstract"));
        book.setBookOnlinePdf(ParamUtil.getBoolean(request, "bookOnlinePdf"));
        book.setBookPageCount(ParamUtil.getInteger(request, "bookPageCount"));
        book.setBookPublishDate(getDate(request, "bookPublishDate"));

        _bookLocalService.updateBook(book);

        sendRedirect(request, response);
    }


    public void deleteBook(ActionRequest request, ActionResponse response)
            throws Exception {

        long bookId = ParamUtil.getLong(request, "bookId");


        if (Validator.isNotNull(bookId)) {
            _bookLocalService.deleteBook(bookId);

            sendRedirect(request, response);
        }
    }

    private Date getDate(PortletRequest request, String fieldName) throws PortalException{
        int dateMonth = ParamUtil.getInteger(request, fieldName+"Month");
        int dateDay = ParamUtil.getInteger(request, fieldName+"Day");
        int dateYear = ParamUtil.getInteger(request, fieldName+"Year");
        int dateHour = ParamUtil.getInteger(request, fieldName+"Hour");
        int dateMinute = ParamUtil.getInteger(request, fieldName+"Minute");
        int dateAmPm = ParamUtil.getInteger(request, fieldName+"AmPm");

        if (dateAmPm == Calendar.PM) {
            dateHour += 12;
        }
        return PortalUtil.getDate(dateMonth, dateDay, dateYear, (dateAmPm == Calendar.PM ? dateHour+12 : dateHour), dateMinute, PortalException.class);

    }

    @Reference
    private BookLocalService _bookLocalService;

    private static Log _log = LogFactoryUtil.getLog(BookPortlet.class);

}
