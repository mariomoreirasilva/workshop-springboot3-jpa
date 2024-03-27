package com.educandoweb.course.entities.enums;

//quando não coloca... (1) o enum começa com 0, 1, 2, .. até acabar.
//para resolver tem que criar um contrutor que no enum é especial, private
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
	
	public int getCod() {
		return code;
	}
	
	//varrer o enum para retornar a string que representa o codigo(code)
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCod() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código status inválido");
	}
	

}
