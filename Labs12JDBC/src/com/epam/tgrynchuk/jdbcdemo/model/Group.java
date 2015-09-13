package com.epam.tgrynchuk.jdbcdemo.model;

import com.epam.tgrynchuk.jdbcdemo.annot.Field;
import static com.epam.tgrynchuk.jdbcdemo.annot.Operations.*;

public class Group {
	private Integer id;
	
	private String name;
	
	@Field(fieldName = "id", type = GET)
	public Integer getId() {
		return id;
	}
	
	@Field(fieldName = "name", type = GET)
	public String getName() {
		return name;
	}
	
	@Field(fieldName = "id", type = SET)
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Field(fieldName = "name", type = SET)
	public void setName(String string) {
		this.name = string;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	public Group(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Group() {}
}
