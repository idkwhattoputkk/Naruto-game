package model;

import java.util.ArrayList;

public class Game {
	private String name;
	private ArrayList<Clan> clans;
	
	public Game() {
		this.name="naruto's shippuden";
		clans = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
}
