package com.vispractice.pages;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import com.vispractice.domain.Match;
import com.vispractice.support.MongoGridDataSource;

public class Contact
{

	@Inject 
	private MongoTemplate mt;
	@Property
	private GridDataSource gds;
	
	void setupRender(){
		gds = new MongoGridDataSource(mt,new Criteria(),Match.class);
	}
}
