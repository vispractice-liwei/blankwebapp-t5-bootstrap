package com.vispractice.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.SetupRender;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.google.common.eventbus.EventBus;
import com.vispractice.domain.League;
import com.vispractice.domain.MItem;
import com.vispractice.domain.Match;
import com.vispractice.domain.Team;
import com.vispractice.repository.LeagueRepository;
import com.vispractice.repository.MatchRepository;
import com.vispractice.repository.TeamRepository;

public class About
{

	@Inject LeagueRepository lr;
	@Inject MatchRepository mr;
	@Inject TeamRepository tr;
	@Inject EventBus eb;
	@Inject MongoTemplate mt;
	
	@SetupRender
	void before(){
//		tr.save(generateTeams());
//		lr.save(generateLeagues());
//		mr.save(generateMatchs());
//		eb.post(new EventObject("About"));
	}
	
	@AfterRender
	void after(){
//		dumpLeagues();
//		dumpTeams();
//		dumpMatches();
	}
	
	List<League> generateLeagues(){
		List<League> ls = new ArrayList<League>(10);
		for(int j=0;j<1000;j++){
			League l = new League();
			l.setName("L"+j);
			l.setSeason("2013");
			ls.add(l);
		}
		return ls;
	}
	
	List<Team> generateTeams(){
		List<Team> ls = new ArrayList<Team>(10);
		for(int j=0;j<10;j++){
			Team l = new Team();
			l.setName("T"+j);
			l.setNotes(UUID.randomUUID().toString());
			ls.add(l);
		}
		return ls;
	}
	
	List<Match> generateMatchs(){
		
		List<Match> ls = new ArrayList<Match>(10);
		for(int j=0;j<1*10000;j++){
			Match l = new Match();
			l.setName("M"+j);
			l.setHome(tr.findByName("T"+(int)(Math.random()*10)));
			l.setGuest(tr.findByName("T"+(int)(Math.random()*10)));
			l.setHomeGoal((int)(Math.random()*1000));
			l.setGuestGoal((int)(Math.random()*1000));
			League lea = lr.findByNameAndSeason("L"+(int)(Math.random()*1000), "2013");
			if(lea.getTeams() == null){
				lea.setTeams(new HashSet<Team>());
			}
			l.setNotes(lea.getName());
//			lea.getTeams().add(l.getHome());
//			lea.getTeams().add(l.getGuest());
			l.setLeague(lea);
			l.setItems(generateMItems());
			ls.add(l);
			
			lr.save(lea);
		}
		return ls;
	}
	
	List<MItem> generateMItems(){
		int randomCount = (int)(Math.random()*100);
		List<MItem> items = new ArrayList<MItem>(randomCount);
		for(int j=0;j<randomCount;j++){
			items.add(new MItem("item"+j,Math.random(),Math.random(),Math.random()
					,Math.random(),Math.random(),Math.random()));
		}
		return items;
	}
	
	void dumpLeagues(){
		Iterator<League> ui = mt.find(new BasicQuery("{'name':\"L148\"}").with(
				new PageRequest(0,10)), League.class).iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
	
	void dumpTeams(){
		Iterator<Team> ui = tr.findByName2("T1", new PageRequest(0,10)).iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
	
	void dumpMatches(){
		try {

			Match ui = mr.findByVersusId(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
					parse("2013-08-12 16:09:32"), "M2",
					"889fb49c-61f7-470f-ac4d-f302ee38693d");
			System.out.println(ui);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
