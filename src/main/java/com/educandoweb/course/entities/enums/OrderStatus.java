package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	/**
	 * Returns the {@code OrderStatus} corresponding to the given code.
	 *
	 * @param code the status code to look up
	 * @return the matching {@code OrderStatus}
	 * @throws IllegalArgumentException if no {@code OrderStatus} exists for the given code
	 */
	public static OrderStatus valueOf(int code) {
		for(OrderStatus orderStatus : OrderStatus.values()) {
			if(code == orderStatus.getCode()) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
