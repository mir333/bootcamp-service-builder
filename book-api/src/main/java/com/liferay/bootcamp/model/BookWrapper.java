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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	@Override
	public Class<?> getModelClass() {
		return Book.class;
	}

	@Override
	public String getModelClassName() {
		return Book.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bookId", getBookId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bookName", getBookName());
		attributes.put("bookAbstract", getBookAbstract());
		attributes.put("bookAuthorName", getBookAuthorName());
		attributes.put("bookOnlinePdf", getBookOnlinePdf());
		attributes.put("bookPageCount", getBookPageCount());
		attributes.put("bookPublishDate", getBookPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String bookName = (String)attributes.get("bookName");

		if (bookName != null) {
			setBookName(bookName);
		}

		String bookAbstract = (String)attributes.get("bookAbstract");

		if (bookAbstract != null) {
			setBookAbstract(bookAbstract);
		}

		String bookAuthorName = (String)attributes.get("bookAuthorName");

		if (bookAuthorName != null) {
			setBookAuthorName(bookAuthorName);
		}

		Boolean bookOnlinePdf = (Boolean)attributes.get("bookOnlinePdf");

		if (bookOnlinePdf != null) {
			setBookOnlinePdf(bookOnlinePdf);
		}

		Integer bookPageCount = (Integer)attributes.get("bookPageCount");

		if (bookPageCount != null) {
			setBookPageCount(bookPageCount);
		}

		Date bookPublishDate = (Date)attributes.get("bookPublishDate");

		if (bookPublishDate != null) {
			setBookPublishDate(bookPublishDate);
		}
	}

	/**
	* Returns the book online pdf of this book.
	*
	* @return the book online pdf of this book
	*/
	@Override
	public boolean getBookOnlinePdf() {
		return _book.getBookOnlinePdf();
	}

	/**
	* Returns <code>true</code> if this book is book online pdf.
	*
	* @return <code>true</code> if this book is book online pdf; <code>false</code> otherwise
	*/
	@Override
	public boolean isBookOnlinePdf() {
		return _book.isBookOnlinePdf();
	}

	@Override
	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _book.isNew();
	}

	@Override
	public com.liferay.bootcamp.model.Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public com.liferay.bootcamp.model.Book toUnescapedModel() {
		return new BookWrapper(_book.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.bootcamp.model.Book> toCacheModel() {
		return _book.toCacheModel();
	}

	@Override
	public int compareTo(com.liferay.bootcamp.model.Book book) {
		return _book.compareTo(book);
	}

	/**
	* Returns the book page count of this book.
	*
	* @return the book page count of this book
	*/
	@Override
	public int getBookPageCount() {
		return _book.getBookPageCount();
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	/**
	* Returns the book abstract of this book.
	*
	* @return the book abstract of this book
	*/
	@Override
	public java.lang.String getBookAbstract() {
		return _book.getBookAbstract();
	}

	/**
	* Returns the book author name of this book.
	*
	* @return the book author name of this book
	*/
	@Override
	public java.lang.String getBookAuthorName() {
		return _book.getBookAuthorName();
	}

	/**
	* Returns the book name of this book.
	*
	* @return the book name of this book
	*/
	@Override
	public java.lang.String getBookName() {
		return _book.getBookName();
	}

	/**
	* Returns the user uuid of this book.
	*
	* @return the user uuid of this book
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _book.getUserUuid();
	}

	/**
	* Returns the uuid of this book.
	*
	* @return the uuid of this book
	*/
	@Override
	public java.lang.String getUuid() {
		return _book.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	/**
	* Returns the book publish date of this book.
	*
	* @return the book publish date of this book
	*/
	@Override
	public Date getBookPublishDate() {
		return _book.getBookPublishDate();
	}

	/**
	* Returns the create date of this book.
	*
	* @return the create date of this book
	*/
	@Override
	public Date getCreateDate() {
		return _book.getCreateDate();
	}

	/**
	* Returns the modified date of this book.
	*
	* @return the modified date of this book
	*/
	@Override
	public Date getModifiedDate() {
		return _book.getModifiedDate();
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	@Override
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Returns the company ID of this book.
	*
	* @return the company ID of this book
	*/
	@Override
	public long getCompanyId() {
		return _book.getCompanyId();
	}

	/**
	* Returns the group ID of this book.
	*
	* @return the group ID of this book
	*/
	@Override
	public long getGroupId() {
		return _book.getGroupId();
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	@Override
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	/**
	* Returns the user ID of this book.
	*
	* @return the user ID of this book
	*/
	@Override
	public long getUserId() {
		return _book.getUserId();
	}

	@Override
	public void persist() {
		_book.persist();
	}

	/**
	* Sets the book abstract of this book.
	*
	* @param bookAbstract the book abstract of this book
	*/
	@Override
	public void setBookAbstract(java.lang.String bookAbstract) {
		_book.setBookAbstract(bookAbstract);
	}

	/**
	* Sets the book author name of this book.
	*
	* @param bookAuthorName the book author name of this book
	*/
	@Override
	public void setBookAuthorName(java.lang.String bookAuthorName) {
		_book.setBookAuthorName(bookAuthorName);
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	@Override
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Sets the book name of this book.
	*
	* @param bookName the book name of this book
	*/
	@Override
	public void setBookName(java.lang.String bookName) {
		_book.setBookName(bookName);
	}

	/**
	* Sets whether this book is book online pdf.
	*
	* @param bookOnlinePdf the book online pdf of this book
	*/
	@Override
	public void setBookOnlinePdf(boolean bookOnlinePdf) {
		_book.setBookOnlinePdf(bookOnlinePdf);
	}

	/**
	* Sets the book page count of this book.
	*
	* @param bookPageCount the book page count of this book
	*/
	@Override
	public void setBookPageCount(int bookPageCount) {
		_book.setBookPageCount(bookPageCount);
	}

	/**
	* Sets the book publish date of this book.
	*
	* @param bookPublishDate the book publish date of this book
	*/
	@Override
	public void setBookPublishDate(Date bookPublishDate) {
		_book.setBookPublishDate(bookPublishDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this book.
	*
	* @param companyId the company ID of this book
	*/
	@Override
	public void setCompanyId(long companyId) {
		_book.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this book.
	*
	* @param createDate the create date of this book
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_book.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_book.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_book.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this book.
	*
	* @param groupId the group ID of this book
	*/
	@Override
	public void setGroupId(long groupId) {
		_book.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this book.
	*
	* @param modifiedDate the modified date of this book
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_book.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_book.setNew(n);
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this book.
	*
	* @param userId the user ID of this book
	*/
	@Override
	public void setUserId(long userId) {
		_book.setUserId(userId);
	}

	/**
	* Sets the user uuid of this book.
	*
	* @param userUuid the user uuid of this book
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_book.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this book.
	*
	* @param uuid the uuid of this book
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_book.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookWrapper)) {
			return false;
		}

		BookWrapper bookWrapper = (BookWrapper)obj;

		if (Objects.equals(_book, bookWrapper._book)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _book.getStagedModelType();
	}

	@Override
	public Book getWrappedModel() {
		return _book;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _book.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _book.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private final Book _book;
}