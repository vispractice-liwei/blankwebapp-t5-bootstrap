package com.vispractice.pages;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import com.vispractice.domain.HItem;
import com.vispractice.domain.League;
import com.vispractice.domain.Reduced;
import com.vispractice.support.IDataFilter;
import com.vispractice.support.MongoGridDataSource;
import com.vispractice.support.MongoSelectModel;

/**
 * Start page of application t5-demo.
 */
public class Index
{
	@Inject 
	private MongoTemplate mt;
	@Property
	@Persist
	private MongoGridDataSource gds;
	@Property
	private Reduced reduced;
	@Property
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	@Property
	private String leagueId;
	@Property
	@Persist
	private SelectModel sm;
	@InjectComponent
	private Zone gzone;
	@Property
	private HItem hitem;
	@Persist
	private String currentLea;
	
	void setupRender(){
		if(gds == null)
			gds = new MongoGridDataSource(mt,new Criteria(),Reduced.class,
					new IDataFilter(){
						@Override
						public boolean suitable(Object data) {
							final String clea = currentLea;
							Reduced r = (Reduced)data;
							Iterator<HItem> hii = r.getValue().getHitem().iterator();
							while(hii.hasNext()){
								HItem hi = hii.next();
								if(!hi.getLea().equals(clea)){
									hii.remove();
								}
							}
							
							return true;
						}
			});
		if(sm == null)
			sm = new MongoSelectModel(mt,League.class);
	}
	
	public Object onValueChanged(String lea){
		currentLea = lea;
		(gds).setCriteria(Criteria.where("value.hitem.lea").is(lea));
		return gzone.getBody();
    }
    
}
