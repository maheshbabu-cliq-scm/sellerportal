package com.sellerportal.ism.i18n.core.sqlparser;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Pojo to hold the configuration of a table for multilingual enablement
 * @author Chandra Singh Meena
 *
 */
public class TableMetaDataDTO {
	private String tableName;
	private String [] pk;
	private boolean isMultipleLanguage;
	private String [] columns;
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public boolean isMultipleLanguage() {
		return isMultipleLanguage;
	}
	public void setMultipleLanguage(boolean isMultipleLanguage) {
		this.isMultipleLanguage = isMultipleLanguage;
	}
	public String[] getPk() {
		return pk;
	}
	public void setPk(String[] pk) {
		this.pk = pk;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((tableName == null) ? 0 : tableName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TableMetaDataDTO other = (TableMetaDataDTO) obj;
		
		
		if (tableName == null) {
			if (other.tableName != null)
				return false;
		} else if (!tableName.equals(other.tableName))
			return false;
		return true;
	}
	public String toString()
	{
		
		return new ToStringBuilder(this)
        .append("Table", getTableName())
        .append("PK", Arrays.toString(getPk()))
        .append("Columns", Arrays.toString(getColumns()))
        .append("IsMultiLingual", isMultipleLanguage())
        .toString();
	}
}
