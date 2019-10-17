package com.software.project.model;

public class Room {
	private int room_id;
	private int type;
	private double price;
	private boolean state;
	
	public Room() {
		super();
	}

	public Room(int room_id, int type) {
		super();
		this.room_id = room_id;
		this.type = type;
	}

	public Room(int room_id, int type, double price, boolean state) {
		super();
		this.room_id = room_id;
		this.type = type;
		this.price = price;
		this.state = state;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
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
