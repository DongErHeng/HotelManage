package com.software.project.model;

public class Room {
	private String room_id;
	private String type;
	private double price;
	private boolean state;
	
	public Room() {
		super();
	}

	public Room(String room_id, String type) {
		super();
		this.room_id = room_id;
		this.type = type;
	}

	public Room(String room_id, String type, double price, boolean state) {
		super();
		this.room_id = room_id;
		this.type = type;
		this.price = price;
		this.state = state;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
