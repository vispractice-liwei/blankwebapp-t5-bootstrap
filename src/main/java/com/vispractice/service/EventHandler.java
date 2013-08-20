/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.service;

import java.util.EventObject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import com.google.common.eventbus.Subscribe;
import com.vispractice.event.EventSubscriber;

/**
 * @author liwei
 *
 */
public class EventHandler implements EventSubscriber,ApplicationContextAware {
	private ApplicationContext context;
	private boolean refreshed = false;
	
	@Subscribe
	public void handleEvent(EventObject eo){
		if(refreshed == false){
			((ConfigurableApplicationContext)context).refresh();
			refreshed = true;
		}
		System.out.println("[EventHandler] "+eo);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
