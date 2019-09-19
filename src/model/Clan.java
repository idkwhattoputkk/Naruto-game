package model;

import uniandes.cupi2.aerolinea.mundo.Character;

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
	public void addOrderedNinja(String name, String personality, String date, int power) {

        Character nuevo = new Character( name, personality, date, power );
        if(firstC == null )
            firstC = nuevo;
        else if( firstC.getPower() > power)
        {
            firstC.insertarAntes( nuevo );
            firstC = nuevo;
        }
        else
        {
            Character CharacterTemp0 = null;
            Character CharacterTemp1 = firstC;
            while( CharacterTemp1 != null && CharacterTemp1.getPower()< power )
            {
                CharacterTemp0 = CharacterTemp1;
                CharacterTemp1 = CharacterTemp1.getNext();
            }
            CharacterTemp0.insertarDespues( nuevo );
        }
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
