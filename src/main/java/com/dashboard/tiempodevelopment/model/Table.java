package com.dashboard.tiempodevelopment.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="table")
public class Table {
	
	@XmlElement(name="row")
	private Row[] row;

	public Row[] getRow() {
		return row;
	}

	public void setRow(Row[] row) {
		this.row = row;
	}

}
