package org.raj.test.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	private int id,value;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", value=" + value + ", name=" + name + "]";
	}
	
}
