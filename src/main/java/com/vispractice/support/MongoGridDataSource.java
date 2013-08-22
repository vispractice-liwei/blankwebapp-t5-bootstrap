/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author liwei
 * 
 */
public class MongoGridDataSource implements GridDataSource {

	private MongoTemplate template;
	private Criteria criteria;
	private Class entityClass;
	private List list;
	private int startIndex;

	public MongoGridDataSource(MongoTemplate template, Criteria criteria,
			Class entityClass) {
		super();
		this.template = template;
		this.criteria = criteria;
		this.entityClass = entityClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tapestry5.grid.GridDataSource#getAvailableRows()
	 */
	@Override
	public int getAvailableRows() {
		return new Long(template.count(new Query(criteria), entityClass)).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tapestry5.grid.GridDataSource#prepare(int, int,
	 * java.util.List)
	 */
	@Override
	public void prepare(int startIndex, int endIndex,
			List<SortConstraint> sortConstraints) {
		Query query = new Query(criteria).skip(startIndex).limit(
						endIndex - startIndex + 1);
		
		int sortSize = sortConstraints.size();
		if(sortSize > 0){
			List<Order> orders = new ArrayList<Order>(sortSize);
			for (SortConstraint constraint : sortConstraints) {
				String propertyName = constraint.getPropertyModel()
						.getPropertyName();
				switch (constraint.getColumnSort()) {
					case ASCENDING:
						orders.add(new Order(Direction.ASC,propertyName));
						break;
					case DESCENDING:
						orders.add(new Order(Direction.DESC,propertyName));
						break;
					default:
				}
			}
			
			query.with(new Sort(orders));
		}

		list = template.find(query, entityClass);
		this.startIndex = startIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tapestry5.grid.GridDataSource#getRowValue(int)
	 */
	@Override
	public Object getRowValue(int index) {
		return list.get(index - startIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tapestry5.grid.GridDataSource#getRowType()
	 */
	@Override
	public Class getRowType() {
		return entityClass;
	}

}
