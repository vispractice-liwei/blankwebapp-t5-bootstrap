package com.vispractice.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Match extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -5889111320640902359L;

	@Column(unique = true)
	private String uuid;

	private String name;
	private String notes;
	
	@ManyToOne(optional = true)
    @JoinColumn(name = "leagueId")
	private League league;
	
	@OneToOne(optional = false)  
	@JoinColumn(name = "homeTeamId")
	private Team home;
	@OneToOne(optional = false)  
	@JoinColumn(name = "guestTeamId")
	private Team guest;

	public Match() {
		this(null);
	}

	public Match(Long id) {
		this.setId(id);
		this.setUuid(UUID.randomUUID().toString());
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

}
