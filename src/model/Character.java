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
	
	
	
}
