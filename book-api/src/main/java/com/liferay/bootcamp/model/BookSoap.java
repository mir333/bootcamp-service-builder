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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.bootcamp.service.http.BookServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.bootcamp.service.http.BookServiceSoap
 * @generated
 */
@ProviderType
public class BookSoap implements Serializable {
	public static BookSoap toSoapModel(Book model) {
		BookSoap soapModel = new BookSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBookId(model.getBookId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBookName(model.getBookName());
		soapModel.setBookAbstract(model.getBookAbstract());
		soapModel.setBookAuthorName(model.getBookAuthorName());
		soapModel.setBookOnlinePdf(model.getBookOnlinePdf());
		soapModel.setBookPageCount(model.getBookPageCount());
		soapModel.setBookPublishDate(model.getBookPublishDate());

		return soapModel;
	}

	public static BookSoap[] toSoapModels(Book[] models) {
		BookSoap[] soapModels = new BookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookSoap[][] toSoapModels(Book[][] models) {
		BookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookSoap[] toSoapModels(List<Book> models) {
		List<BookSoap> soapModels = new ArrayList<BookSoap>(models.size());

		for (Book model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookSoap[soapModels.size()]);
	}

	public BookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getBookName() {
		return _bookName;
	}

	public void setBookName(String bookName) {
		_bookName = bookName;
	}

	public String getBookAbstract() {
		return _bookAbstract;
	}

	public void setBookAbstract(String bookAbstract) {
		_bookAbstract = bookAbstract;
	}

	public String getBookAuthorName() {
		return _bookAuthorName;
	}

	public void setBookAuthorName(String bookAuthorName) {
		_bookAuthorName = bookAuthorName;
	}

	public boolean getBookOnlinePdf() {
		return _bookOnlinePdf;
	}

	public boolean isBookOnlinePdf() {
		return _bookOnlinePdf;
	}

	public void setBookOnlinePdf(boolean bookOnlinePdf) {
		_bookOnlinePdf = bookOnlinePdf;
	}

	public int getBookPageCount() {
		return _bookPageCount;
	}

	public void setBookPageCount(int bookPageCount) {
		_bookPageCount = bookPageCount;
	}

	public Date getBookPublishDate() {
		return _bookPublishDate;
	}

	public void setBookPublishDate(Date bookPublishDate) {
		_bookPublishDate = bookPublishDate;
	}

	private String _uuid;
	private long _bookId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _bookName;
	private String _bookAbstract;
	private String _bookAuthorName;
	private boolean _bookOnlinePdf;
	private int _bookPageCount;
	private Date _bookPublishDate;
}