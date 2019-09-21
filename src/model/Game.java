package model;

import java.util.ArrayList;

public class Game {
	private String name;
	private Clan firstClan;
	private Clan lastClan;
	
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

	public Clan getfirstClanlan() {
		return firstClan;
	}

	public void setfirstClanlan(Clan firstClan) {
		this.firstClan = firstClan;
	}
	public void addOrderedClan(String name) {

        Clan nuevo = new Clan( name);
        if(firstClan == null )
            firstClan = nuevo;
        else if( firstClan.compareByName(nuevo)>0)
        {
            firstClan.addBefore( nuevo );
            firstClan = nuevo;
        }
        else
        {
            Clan ClanTemp0 = null;
            Clan ClanTemp1 = firstClan;
            while( ClanTemp1 != null && ClanTemp1.compareByName(nuevo)<0 )
            {
                ClanTemp0 = ClanTemp1;
                ClanTemp1 = ClanTemp1.getNext();
            }
            ClanTemp0.addAfter( nuevo );
        }
	}

}
