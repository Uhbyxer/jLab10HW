package com.epam.tgrynchuk.jdbcdemo.model;

import java.util.Date;

public class Student {
	private Integer id;
	
	private String name;
	
	private String fathername;
	
	private String surname;
	
	private Boolean sex;
	
	private Date birth;
	
	private Speciality speciality;
	
	private Group group;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFathername() {
		return fathername;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirth() {
		return birth;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public Group getGroup() {
		return group;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Boolean isMale() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", speciality="
				+ speciality + ", group=" + group + "]";
	}
	
	
}
