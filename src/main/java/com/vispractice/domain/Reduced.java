/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.domain;

import org.springframework.data.annotation.Id;

/**
 * @author Administrator
 *
 */
public class Reduced {

	@Id
	private String id;
	private ValueObj value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ValueObj getValue() {
		return value;
	}
	public void setValue(ValueObj value) {
		this.value = value;
	}
}
