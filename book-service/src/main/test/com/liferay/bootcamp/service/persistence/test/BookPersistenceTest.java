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

package com.liferay.bootcamp.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.bootcamp.exception.NoSuchBookException;
import com.liferay.bootcamp.model.Book;
import com.liferay.bootcamp.service.BookLocalServiceUtil;
import com.liferay.bootcamp.service.persistence.BookPersistence;
import com.liferay.bootcamp.service.persistence.BookUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BookPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = BookUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Book> iterator = _books.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Book book = _persistence.create(pk);

		Assert.assertNotNull(book);

		Assert.assertEquals(book.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Book newBook = addBook();

		_persistence.remove(newBook);

		Book existingBook = _persistence.fetchByPrimaryKey(newBook.getPrimaryKey());

		Assert.assertNull(existingBook);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBook();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Book newBook = _persistence.create(pk);

		newBook.setUuid(RandomTestUtil.randomString());

		newBook.setCompanyId(RandomTestUtil.nextLong());

		newBook.setGroupId(RandomTestUtil.nextLong());

		newBook.setUserId(RandomTestUtil.nextLong());

		newBook.setCreateDate(RandomTestUtil.nextDate());

		newBook.setModifiedDate(RandomTestUtil.nextDate());

		newBook.setBookName(RandomTestUtil.randomString());

		newBook.setBookAbstract(RandomTestUtil.randomString());

		newBook.setBookAuthorName(RandomTestUtil.randomString());

		newBook.setBookOnlinePdf(RandomTestUtil.randomBoolean());

		newBook.setBookPageCount(RandomTestUtil.nextInt());

		newBook.setBookPublishDate(RandomTestUtil.nextDate());

		_books.add(_persistence.update(newBook));

		Book existingBook = _persistence.findByPrimaryKey(newBook.getPrimaryKey());

		Assert.assertEquals(existingBook.getUuid(), newBook.getUuid());
		Assert.assertEquals(existingBook.getBookId(), newBook.getBookId());
		Assert.assertEquals(existingBook.getCompanyId(), newBook.getCompanyId());
		Assert.assertEquals(existingBook.getGroupId(), newBook.getGroupId());
		Assert.assertEquals(existingBook.getUserId(), newBook.getUserId());
		Assert.assertEquals(Time.getShortTimestamp(existingBook.getCreateDate()),
			Time.getShortTimestamp(newBook.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingBook.getModifiedDate()),
			Time.getShortTimestamp(newBook.getModifiedDate()));
		Assert.assertEquals(existingBook.getBookName(), newBook.getBookName());
		Assert.assertEquals(existingBook.getBookAbstract(),
			newBook.getBookAbstract());
		Assert.assertEquals(existingBook.getBookAuthorName(),
			newBook.getBookAuthorName());
		Assert.assertEquals(existingBook.getBookOnlinePdf(),
			newBook.getBookOnlinePdf());
		Assert.assertEquals(existingBook.getBookPageCount(),
			newBook.getBookPageCount());
		Assert.assertEquals(Time.getShortTimestamp(
				existingBook.getBookPublishDate()),
			Time.getShortTimestamp(newBook.getBookPublishDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountBybookAuthorName() throws Exception {
		_persistence.countBybookAuthorName(StringPool.BLANK);

		_persistence.countBybookAuthorName(StringPool.NULL);

		_persistence.countBybookAuthorName((String)null);
	}

	@Test
	public void testCountBybookOnlinePdf() throws Exception {
		_persistence.countBybookOnlinePdf(RandomTestUtil.randomBoolean());

		_persistence.countBybookOnlinePdf(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Book newBook = addBook();

		Book existingBook = _persistence.findByPrimaryKey(newBook.getPrimaryKey());

		Assert.assertEquals(existingBook, newBook);
	}

	@Test(expected = NoSuchBookException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Book> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("BOOK_Book", "uuid", true,
			"bookId", true, "companyId", true, "groupId", true, "userId", true,
			"createDate", true, "modifiedDate", true, "bookName", true,
			"bookAbstract", true, "bookAuthorName", true, "bookOnlinePdf",
			true, "bookPageCount", true, "bookPublishDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Book newBook = addBook();

		Book existingBook = _persistence.fetchByPrimaryKey(newBook.getPrimaryKey());

		Assert.assertEquals(existingBook, newBook);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Book missingBook = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBook);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Book newBook1 = addBook();
		Book newBook2 = addBook();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook1.getPrimaryKey());
		primaryKeys.add(newBook2.getPrimaryKey());

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, books.size());
		Assert.assertEquals(newBook1, books.get(newBook1.getPrimaryKey()));
		Assert.assertEquals(newBook2, books.get(newBook2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(books.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Book newBook = addBook();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, books.size());
		Assert.assertEquals(newBook, books.get(newBook.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(books.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Book newBook = addBook();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBook.getPrimaryKey());

		Map<Serializable, Book> books = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, books.size());
		Assert.assertEquals(newBook, books.get(newBook.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = BookLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Book>() {
				@Override
				public void performAction(Book book) {
					Assert.assertNotNull(book);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Book newBook = addBook();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Book.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("bookId",
				newBook.getBookId()));

		List<Book> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Book existingBook = result.get(0);

		Assert.assertEquals(existingBook, newBook);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Book.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("bookId",
				RandomTestUtil.nextLong()));

		List<Book> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Book newBook = addBook();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Book.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		Object newBookId = newBook.getBookId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("bookId",
				new Object[] { newBookId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBookId = result.get(0);

		Assert.assertEquals(existingBookId, newBookId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Book.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bookId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("bookId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Book newBook = addBook();

		_persistence.clearCache();

		Book existingBook = _persistence.findByPrimaryKey(newBook.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingBook.getUuid(),
				ReflectionTestUtil.invoke(existingBook, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingBook.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingBook, "getOriginalGroupId",
				new Class<?>[0]));
	}

	protected Book addBook() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Book book = _persistence.create(pk);

		book.setUuid(RandomTestUtil.randomString());

		book.setCompanyId(RandomTestUtil.nextLong());

		book.setGroupId(RandomTestUtil.nextLong());

		book.setUserId(RandomTestUtil.nextLong());

		book.setCreateDate(RandomTestUtil.nextDate());

		book.setModifiedDate(RandomTestUtil.nextDate());

		book.setBookName(RandomTestUtil.randomString());

		book.setBookAbstract(RandomTestUtil.randomString());

		book.setBookAuthorName(RandomTestUtil.randomString());

		book.setBookOnlinePdf(RandomTestUtil.randomBoolean());

		book.setBookPageCount(RandomTestUtil.nextInt());

		book.setBookPublishDate(RandomTestUtil.nextDate());

		_books.add(_persistence.update(book));

		return book;
	}

	private List<Book> _books = new ArrayList<Book>();
	private BookPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}