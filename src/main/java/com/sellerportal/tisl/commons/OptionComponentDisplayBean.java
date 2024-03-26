package com.sellerportal.tisl.commons;

import java.io.Serializable;


@SuppressWarnings("serial")
public class OptionComponentDisplayBean implements Serializable{
	
	private String id = null;
	private String optionLabel = null;
	private String optionValue = null;
	private boolean optionSelected = false;
	
	public OptionComponentDisplayBean(String id, String optionLabel, String optionValue,
		boolean optionSelected) {
		this.id = id;
		this.optionLabel = optionLabel;
		this.optionValue = optionValue;
		this.optionSelected = optionSelected;
	}
	
	public OptionComponentDisplayBean() {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOptionLabel() {
		return optionLabel;
	}
	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	public boolean isOptionSelected() {
		return optionSelected;
	}
	public void setOptionSelected(boolean optionSelected) {
		this.optionSelected = optionSelected;
	}
}
