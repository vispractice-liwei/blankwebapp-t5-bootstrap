package com.vispractice.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

	@Id
	private String id;
	@Indexed
	private String name;
	private String notes;

	public Team() {
		this.setId(UUID.randomUUID().toString());
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

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", notes=" + notes
				+ "]";
	}

}
