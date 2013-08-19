package com.vispractice.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.SetupRender;

import com.vispractice.domain.League;
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
	
	@SetupRender
	void before(){
//		lr.save(generateLeagues());
//		tr.save(generateTeams());
//		mr.save(generateMatchs());
	}
	
	@AfterRender
	void after(){
//		dumpLeagues();
//		dumpTeams();
//		dumpMatches();
		dumpMatchesToLeague();
	}
	
	List<League> generateLeagues(){
		List<League> ls = new ArrayList<League>(10);
		for(int j=0;j<10;j++){
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
		for(int j=0;j<10;j++){
			Match l = new Match();
			l.setName("M"+j);
			l.setNotes(UUID.randomUUID().toString());
			l.setHome(tr.findByName("T"+(int)(Math.random()*10)));
			l.setGuest(tr.findByName("T"+(int)(Math.random()*10)));
			l.setLeague(lr.findByNameAndSeason("L"+(int)(Math.random()*10), "2013"));
			ls.add(l);
		}
		return ls;
	}
	
	void dumpLeagues(){
		Iterator<League> ui = lr.findAll().iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
	
	void dumpTeams(){
		Iterator<Team> ui = tr.findAll().iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
	
	void dumpMatches(){
		Iterator<Match> ui = mr.findAll().iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
	
	void dumpMatchesToLeague(){
		Iterator<Match> ui = mr.findAll().iterator();
		while(ui.hasNext()){
			Match m = (ui.next());
			League l = lr.findOne(m.getLeague().getId());
			l.getMatches().add(m);
			lr.save(l);
		}
	}
}
