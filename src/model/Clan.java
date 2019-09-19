package model;

public class Clan {
	//attributes
	private String name;
	private int numNinjas;
	private Character firstC;
	//methods
	public Clan(String name) {
		this.name = name;
		this.numNinjas=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumNinjas() {
		return numNinjas;
	}
	public void setNumNinjas(int numNinjas) {
		this.numNinjas = numNinjas;
	}
	public Character getFirstC() {
		return firstC;
	}
	public void setFirstC(Character firstC) {
		this.firstC = firstC;
	}
	
	
}
