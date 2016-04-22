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

package com.liferay.bootcamp.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.bootcamp.model.Book;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookCacheModel implements CacheModel<Book>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookCacheModel)) {
			return false;
		}

		BookCacheModel bookCacheModel = (BookCacheModel)obj;

		if (bookId == bookCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append(", bookAbstract=");
		sb.append(bookAbstract);
		sb.append(", bookAuthorName=");
		sb.append(bookAuthorName);
		sb.append(", bookOnlinePdf=");
		sb.append(bookOnlinePdf);
		sb.append(", bookPageCount=");
		sb.append(bookPageCount);
		sb.append(", bookPublishDate=");
		sb.append(bookPublishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		if (uuid == null) {
			bookImpl.setUuid(StringPool.BLANK);
		}
		else {
			bookImpl.setUuid(uuid);
		}

		bookImpl.setBookId(bookId);
		bookImpl.setCompanyId(companyId);
		bookImpl.setGroupId(groupId);
		bookImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			bookImpl.setCreateDate(null);
		}
		else {
			bookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookImpl.setModifiedDate(null);
		}
		else {
			bookImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bookName == null) {
			bookImpl.setBookName(StringPool.BLANK);
		}
		else {
			bookImpl.setBookName(bookName);
		}

		if (bookAbstract == null) {
			bookImpl.setBookAbstract(StringPool.BLANK);
		}
		else {
			bookImpl.setBookAbstract(bookAbstract);
		}

		if (bookAuthorName == null) {
			bookImpl.setBookAuthorName(StringPool.BLANK);
		}
		else {
			bookImpl.setBookAuthorName(bookAuthorName);
		}

		bookImpl.setBookOnlinePdf(bookOnlinePdf);
		bookImpl.setBookPageCount(bookPageCount);

		if (bookPublishDate == Long.MIN_VALUE) {
			bookImpl.setBookPublishDate(null);
		}
		else {
			bookImpl.setBookPublishDate(new Date(bookPublishDate));
		}

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bookName = objectInput.readUTF();
		bookAbstract = objectInput.readUTF();
		bookAuthorName = objectInput.readUTF();

		bookOnlinePdf = objectInput.readBoolean();

		bookPageCount = objectInput.readInt();
		bookPublishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bookName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookName);
		}

		if (bookAbstract == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookAbstract);
		}

		if (bookAuthorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookAuthorName);
		}

		objectOutput.writeBoolean(bookOnlinePdf);

		objectOutput.writeInt(bookPageCount);
		objectOutput.writeLong(bookPublishDate);
	}

	public String uuid;
	public long bookId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String bookName;
	public String bookAbstract;
	public String bookAuthorName;
	public boolean bookOnlinePdf;
	public int bookPageCount;
	public long bookPublishDate;
}