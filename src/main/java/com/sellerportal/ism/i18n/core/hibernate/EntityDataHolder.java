package com.sellerportal.ism.i18n.core.hibernate;

import java.io.Serializable;

import org.hibernate.type.Type;

public class EntityDataHolder {
	//onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
	private Object entity;
	private Serializable id;
	private Object [] currentState;
	private Object [] previousState;
	private String [] propertyNams;
	private Type [] types;
	
	
	
	public EntityDataHolder(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNams, Type[] types) {
		super();
		this.entity = entity;
		this.id = id;
		this.currentState = currentState;
		this.previousState = previousState;
		this.propertyNams = propertyNams;
		this.types = types;
	}
	
	public Object[] getCurrentState() {
		return currentState;
	}
	public void setCurrentState(Object[] currentState) {
		this.currentState = currentState;
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public Serializable getId() {
		return id;
	}
	public void setId(Serializable id) {
		this.id = id;
	}
	public Object[] getPreviousState() {
		return previousState;
	}
	public void setPreviousState(Object[] previousState) {
		this.previousState = previousState;
	}
	public String[] getPropertyNams() {
		return propertyNams;
	}
	public void setPropertyNams(String[] propertyNams) {
		this.propertyNams = propertyNams;
	}
	public Type[] getTypes() {
		return types;
	}
	public void setTypes(Type[] types) {
		this.types = types;
	}
	
	
}
