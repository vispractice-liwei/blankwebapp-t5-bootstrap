/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.domain;

/**
 * @author Administrator
 *
 */
public class MItem {

	private String name;
	private double i1;
	private double i2;
	private double i3;
	private double i4;
	private double i5;
	private double i6;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getI1() {
		return i1;
	}
	public void setI1(double i1) {
		this.i1 = i1;
	}
	public double getI2() {
		return i2;
	}
	public void setI2(double i2) {
		this.i2 = i2;
	}
	public double getI3() {
		return i3;
	}
	public void setI3(double i3) {
		this.i3 = i3;
	}
	public double getI4() {
		return i4;
	}
	public void setI4(double i4) {
		this.i4 = i4;
	}
	public double getI5() {
		return i5;
	}
	public void setI5(double i5) {
		this.i5 = i5;
	}
	public double getI6() {
		return i6;
	}
	public void setI6(double i6) {
		this.i6 = i6;
	}
	public MItem(String name, double i1, double i2, double i3, double i4,
			double i5, double i6) {
		super();
		this.name = name;
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
		this.i5 = i5;
		this.i6 = i6;
	}
}
