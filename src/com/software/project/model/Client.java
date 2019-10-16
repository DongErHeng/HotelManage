package com.software.project.model;

public class Client {
	private String client_id;
	private String name;
	private boolean sex;
	private int age;
	private String tell;
	
	public Client() {
		super();
	}
	
	public Client(String client_id, String name, boolean sex, int age, String tell) {
		super();
		this.client_id = client_id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tell = tell;
	}
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}

}
