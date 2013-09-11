/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class ValueObj {

	private String name;
	private List<HItem> hitem;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<HItem> getHitem() {
		return hitem;
	}
	public void setHitem(List<HItem> hitem) {
		this.hitem = hitem;
	}
	
}
