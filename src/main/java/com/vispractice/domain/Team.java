package com.vispractice.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Team extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -7521673076229262431L;

	@Column(unique = true)
	private String uuid;

	private String name;
	private String notes;

	public Team() {
		this(null);
	}

	public Team(Long id) {
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

	@Override
	public String toString() {
		return "Team [uuid=" + uuid + ", name=" + name + ", notes=" + notes
				+ "]";
	}

}
