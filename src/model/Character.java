package model;

public class Character {
	//attributtes
	private String name;
	private String personality;
	private String date;
	private int power;
	private Character next;
	private Character prev;
	//methods
	public Character(String name, String personality, String date, int power) {
		this.name = name;
		this.personality = personality;
		this.date = date;
		this.power = power;
		next=null;
		prev=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Character getNext() {
		return next;
	}
	public void setNext(Character next) {
		this.next = next;
	}
	public Character getPrev() {
		return prev;
	}
	public void setPrev(Character prev) {
		this.prev = prev;
	}
	public void insertarDespues(Character nuevo) {
		 nuevo.next = next;
	        if( next != null )
	            next.prev = nuevo;
		        nuevo.prev = this;
		        next = nuevo;
	}
	public void insertarAntes(Character nuevo) {
		if( prev != null )
            prev.next = nuevo;
	        nuevo.prev = prev;
	        nuevo.next = this;
	        prev = nuevo;
	}
	
	
	
}
