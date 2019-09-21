package model;

import java.util.ArrayList;

public class Game {
	private String name;
	private Clan firstClan;
	
	public Game() {
		this.name="naruto's shippuden";
		firstClan = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clan getFirstClan() {
		return firstClan;
	}

	public void setFirstClan(Clan firstClan) {
		this.firstClan = firstClan;
	}

}
