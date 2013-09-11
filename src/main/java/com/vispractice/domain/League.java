package com.vispractice.domain;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndex(name="league_name_season_index",def="{'name':1,'season':1}")
public class League {

	@Id
	private String id;
	@Indexed
	private String name;
	private String season;

	private double score;

	private Set<Match> matches;
	private Set<Team> teams;

	public League() {
		this.setId(UUID.randomUUID().toString());
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
		return "League [id=" + id + ", name=" + name + ", season=" + season
				+ ", score=" + score + ", matches=" + matches + ", teams="
				+ teams + "]";
	}

}
