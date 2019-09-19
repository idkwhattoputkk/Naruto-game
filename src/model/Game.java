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
//	insertion
	public void orderByDateClan() {
		for(int i=1;i<clans.size();i++) {
			Clan toIterate = (Clan) clans.get(i);
			boolean finished =false;
			
			for(int j=i;j>0 && !finished;j--) {
				Clan fromNow=(Clan) clans.get(j-1);
				if(fromNow.compareByName(toIterate)>0) {
					clans.set(j, fromNow);
					clans.set(j-1, toIterate);
				}else {
					finished=true;
				}
			}
		}
	}
}
