/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.bootcamp.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Book service. Represents a row in the &quot;BOOK_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.bootcamp.model.impl.BookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.bootcamp.model.impl.BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @see com.liferay.bootcamp.model.impl.BookImpl
 * @see com.liferay.bootcamp.model.impl.BookModelImpl
 * @generated
 */
@ProviderType
public interface BookModel extends BaseModel<Book>, ShardedModel, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a book model instance should use the {@link Book} interface instead.
	 */

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this book.
	 *
	 * @return the uuid of this book
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this book.
	 *
	 * @param uuid the uuid of this book
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the company ID of this book.
	 *
	 * @return the company ID of this book
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this book.
	 *
	 * @param companyId the company ID of this book
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this book.
	 *
	 * @return the group ID of this book
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this book.
	 *
	 * @param groupId the group ID of this book
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this book.
	 *
	 * @return the user ID of this book
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this book.
	 *
	 * @param userId the user ID of this book
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this book.
	 *
	 * @return the user uuid of this book
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this book.
	 *
	 * @param userUuid the user uuid of this book
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this book.
	 *
	 * @return the create date of this book
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this book.
	 *
	 * @param createDate the create date of this book
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this book.
	 *
	 * @return the modified date of this book
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this book.
	 *
	 * @param modifiedDate the modified date of this book
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the book name of this book.
	 *
	 * @return the book name of this book
	 */
	@AutoEscape
	public String getBookName();

	/**
	 * Sets the book name of this book.
	 *
	 * @param bookName the book name of this book
	 */
	public void setBookName(String bookName);

	/**
	 * Returns the book abstract of this book.
	 *
	 * @return the book abstract of this book
	 */
	@AutoEscape
	public String getBookAbstract();

	/**
	 * Sets the book abstract of this book.
	 *
	 * @param bookAbstract the book abstract of this book
	 */
	public void setBookAbstract(String bookAbstract);

	/**
	 * Returns the book author name of this book.
	 *
	 * @return the book author name of this book
	 */
	@AutoEscape
	public String getBookAuthorName();

	/**
	 * Sets the book author name of this book.
	 *
	 * @param bookAuthorName the book author name of this book
	 */
	public void setBookAuthorName(String bookAuthorName);

	/**
	 * Returns the book online pdf of this book.
	 *
	 * @return the book online pdf of this book
	 */
	public boolean getBookOnlinePdf();

	/**
	 * Returns <code>true</code> if this book is book online pdf.
	 *
	 * @return <code>true</code> if this book is book online pdf; <code>false</code> otherwise
	 */
	public boolean isBookOnlinePdf();

	/**
	 * Sets whether this book is book online pdf.
	 *
	 * @param bookOnlinePdf the book online pdf of this book
	 */
	public void setBookOnlinePdf(boolean bookOnlinePdf);

	/**
	 * Returns the book page count of this book.
	 *
	 * @return the book page count of this book
	 */
	public int getBookPageCount();

	/**
	 * Sets the book page count of this book.
	 *
	 * @param bookPageCount the book page count of this book
	 */
	public void setBookPageCount(int bookPageCount);

	/**
	 * Returns the book publish date of this book.
	 *
	 * @return the book publish date of this book
	 */
	public Date getBookPublishDate();

	/**
	 * Sets the book publish date of this book.
	 *
	 * @param bookPublishDate the book publish date of this book
	 */
	public void setBookPublishDate(Date bookPublishDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.liferay.bootcamp.model.Book book);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.bootcamp.model.Book> toCacheModel();

	@Override
	public com.liferay.bootcamp.model.Book toEscapedModel();

	@Override
	public com.liferay.bootcamp.model.Book toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}