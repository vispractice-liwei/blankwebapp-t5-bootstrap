package com.vispractice.domain;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Cup extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 3596967267270171866L;

	@Column(unique = true)
	private String uuid;

	private String name;
	private String season;
	
	private double score;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "league")
	private Set<Match> matches;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Team> teams;

	public Cup() {
		this(null);
	}

	public Cup(Long id) {
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

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "League [uuid=" + uuid + ", name=" + name + ", season=" + season
				+ ", score=" + score + "]";
	}

}
