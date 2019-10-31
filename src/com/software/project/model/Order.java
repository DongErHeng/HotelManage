package com.software.project.model;

public class Order {
	private int order_id;
	private String client_id;
	private int room_id;
	private String comedate;
	private int days;
	private String leavedate;
	
	public Order() {
		super();
	}

	public Order(String client_id, int room_id) {
		super();
		this.client_id = client_id;
		this.room_id = room_id;
	}

	public Order(String client_id, int room_id, String comedate, int days, String leavedate) {
		super();
		this.client_id = client_id;
		this.room_id = room_id;
		this.comedate = comedate;
		this.days = days;
		this.leavedate = leavedate;
	}

	public Order(int order_id, String client_id, int room_id, String comedate, int days, String leavedate) {
		super();
		this.order_id = order_id;
		this.client_id = client_id;
		this.room_id = room_id;
		this.comedate = comedate;
		this.days = days;
		this.leavedate = leavedate;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getComedate() {
		return comedate;
	}

	public void setComedate(String comedate) {
		this.comedate = comedate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(String leavedate) {
		this.leavedate = leavedate;
	}
	
}
