/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.support;

import java.util.List;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.util.AbstractSelectModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Administrator
 *
 */
public class MongoSelectModel extends AbstractSelectModel {
	private final List<OptionModel> options = CollectionFactory.newList();
	private MongoTemplate template;
	private Class entityClass;
	
	public MongoSelectModel(MongoTemplate template, Class entityClass) {
		super();
		this.template = template;
		this.entityClass = entityClass;
		
		List list =  template.find(
				new Query(new Criteria()).with(new Sort(new Order(Direction.ASC,"name"))), entityClass);
		for(Object obj : list){
			try {
				String name = Ognl.getValue("name", obj).toString();
				options.add(new OptionModelImpl(
						name,/*Ognl.getValue("id", obj)*/name));
			} catch (OgnlException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.tapestry5.SelectModel#getOptionGroups()
	 */
	@Override
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.tapestry5.SelectModel#getOptions()
	 */
	@Override
	public List<OptionModel> getOptions() {
		return options;
	}

}
