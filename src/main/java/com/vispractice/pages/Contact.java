package com.vispractice.pages;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.grid.GridDataSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import com.vispractice.domain.League;
import com.vispractice.domain.Match;
import com.vispractice.support.MongoGridDataSource;
import com.vispractice.support.MongoSelectModel;

public class Contact
{

	@Inject 
	private MongoTemplate mt;
	@Property
	@Persist
	private GridDataSource gds;
	@Property
	private Match match;
	@Property
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	@Property
	private String leagueId;
	@Property
	@Persist
	private SelectModel sm;
	@InjectComponent
	private Zone gzone;
	
	void setupRender(){
		if(gds == null)
			gds = new MongoGridDataSource(mt,new Criteria(),Match.class);
		if(sm == null)
			sm = new MongoSelectModel(mt,League.class);
	}
	
	public Object onValueChanged(String leageId){
		((MongoGridDataSource)gds).setCriteria(Criteria.where("league.$id").is(leageId));
		return gzone.getBody();
    }
}
