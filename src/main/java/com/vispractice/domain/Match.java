package com.vispractice.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Match {

	@Id
	private String id;
	@Indexed
	private String name;
	private String notes;

	@DBRef
	private League league;
	@DBRef
	private Cup cup;
	@DBRef
	private Team home;
	@DBRef
	private Team guest;
	
	private Date kickoff;

	public Match() {
		this.setId(UUID.randomUUID().toString());
		try {
			this.setKickoff(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-08-12 16:09:32"));
		} catch (ParseException e) {}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getGuest() {
		return guest;
	}

	public void setGuest(Team guest) {
		this.guest = guest;
	}

	public Cup getCup() {
		return cup;
	}

	public void setCup(Cup cup) {
		this.cup = cup;
	}

	public Date getKickoff() {
		return kickoff;
	}

	public void setKickoff(Date kickoff) {
		this.kickoff = kickoff;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", name=" + name + ", notes=" + notes
				+ ", league=" + league + ", cup=" + cup + ", home=" + home
				+ ", guest=" + guest + ", kickoff=" + kickoff + "]";
	}

}
