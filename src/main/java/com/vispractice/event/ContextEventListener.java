/*
 * Copyright (c) vispractice
 * 2013.
 */
package com.vispractice.event;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * @author liwei
 *
 */
public class ContextEventListener implements ApplicationContextAware,
									ApplicationListener<ApplicationContextEvent>{

	private ApplicationContext context;
	private EventBus eventBus;
	
	@Override
	public void onApplicationEvent(ApplicationContextEvent event) {
		if(event instanceof ContextStartedEvent || 
				event instanceof ContextRefreshedEvent){
			refreshEventBus();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
	
	private void refreshEventBus(){
		if(eventBus != null){
			unregisterEventBus();
			registerEventBus();
		}
	}
	
	private void registerEventBus(){
		EventBus delegatedEventBus = (EventBus)context.getBean(EventBus.class);
		eventBus = (delegatedEventBus == null ? 
				new AsyncEventBus(new ThreadPoolTaskExecutor()) : delegatedEventBus);
		Map<String,EventSubscriber> subMap = context.getBeansOfType(EventSubscriber.class);
		Iterator<EventSubscriber> esi = subMap.values().iterator();
		while(esi.hasNext()){
			eventBus.register(esi.next());
		}
	}
	
	private void unregisterEventBus(){
		Map<String,EventSubscriber> subMap = context.getBeansOfType(EventSubscriber.class);
		Iterator<EventSubscriber> esi = subMap.values().iterator();
		while(esi.hasNext()){
			eventBus.unregister(esi.next());
		}
	}

}
