package com.epam.tgrynchuk.jdbcdemo.model;

public class Speciality {
	private Integer id;
	
	private String name;
	
	private String about;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String string) {
		this.name = string;
	}

	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	public Speciality() {
		// TODO Auto-generated constructor stub
	}
	public Speciality(Integer id, String name, String about) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
	}
	@Override
	public String toString() {
		return "Speciality [id=" + id + ", name=" + name + "]";
	}
	
	
}
