package com.vispractice.pages;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.SetupRender;

import com.vispractice.domain.User;
import com.vispractice.repository.SimpleUserRepository;

public class About
{

	@Inject
	private SimpleUserRepository sur;
	
	@SetupRender
	void before(){
		sur.save(new User(System.currentTimeMillis()));
	}
	
	@AfterRender
	void after(){
		Iterator<User> ui = sur.findAll().iterator();
		while(ui.hasNext()){
			System.out.println(ui.next());
		}
	}
}
